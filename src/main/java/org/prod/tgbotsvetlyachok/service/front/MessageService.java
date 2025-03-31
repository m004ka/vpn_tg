package org.prod.tgbotsvetlyachok.service.front;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prod.tgbotsvetlyachok.bot.TelegramBot;


import org.prod.tgbotsvetlyachok.client.BackendClient;
import org.prod.tgbotsvetlyachok.service.front.keyBoards.KeyBoardService;
import org.prod.tgbotsvetlyachok.service.front.text.TextMessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final TelegramBot telegramBot;

    private final TextMessageService text;

    private final KeyBoardService keyBoardService;

    private final BackendClient backendClient;


    public void menuMessage(Update update) {
        EditMessageText message = new EditMessageText();
        Long id = getChatId(update);
        int messId = getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.menuText(id, backendClient.getTime(id)));
        message.setReplyMarkup(keyBoardService.getMenuMarkup());

        telegramBot.sendMessage(message);
    }


    public void menuQuery(Update update) {
        Long id = getChatId(update);
        EditMessageText message = new EditMessageText();
        message.setChatId(id);
        message.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        message.setParseMode("HTML");
        if (update.hasCallbackQuery()) {
            System.out.println("Обрабатываем callback-запрос");
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String callbackData = callbackQuery.getData();

            if ("MENU_UPDATE".equals(callbackData)) {
                AnswerCallbackQuery answer = new AnswerCallbackQuery();
                answer.setCallbackQueryId(callbackQuery.getId());
                answer.setText("Svetlyachok_VPN - 👌");
                answer.setShowAlert(false);

                telegramBot.extracted(answer);

            }
        }
        List<Long> day = backendClient.getTime(id);
        if (!day.isEmpty()) {
            message.setText("<b>Аккаунт ID </b>" + id + "\n\n<b>Ключ истекает через\n</b>" + day.get(0) + " дней " + day.get(1) + " часов " + day.get(2) + " минут ");

            message.setReplyMarkup(keyBoardService.getMenuMarkup());
            telegramBot.sendMessage(message);
        }
        message.setText("<b>Аккаунт ID </b>" + id + "\n\n<b>Ошибка</b>");

    }

    public void defaultMessage(Update update) {
        SendMessage message = new SendMessage();
        Long id = getChatId(update);

        message.setChatId(id);
        message.setParseMode("HTML");
        message.setText(text.defaultText());


        telegramBot.sendMessage(message);
    }

    public void startMessage(Update update) {
        SendMessage message = new SendMessage();
        Long id = getChatId(update);

        message.setChatId(id);
        message.setParseMode("HTML");
        message.setText(text.startText(id, backendClient.getTime(id)));
        message.setReplyMarkup(keyBoardService.getMenuMarkup());

        telegramBot.sendMessage(message);
    }


    public Integer getIdLastBotMessage(Update update) {
        Integer id = null;
        if (update.hasCallbackQuery()) {
            try {
                if (update.getMessage() != null) {
                    return update.getMessage().getMessageId();
                }
            } catch (RuntimeException e) {
                log.error("Не удалось получить ID последнего сообщения через getMessage: " + e.getMessage());
            }

            try {
                if (update.getCallbackQuery().getMessage() != null) {
                    return update.getCallbackQuery().getMessage().getMessageId();
                }
            } catch (RuntimeException e) {
                log.error("Не удалось получить ID последнего сообщения через getCallbackQuery: " + e.getMessage());
            }
        }
        return id;
    }

    public Long getChatId(Update update) {
        Long id = null;

        if (update.getCallbackQuery() != null) {
            try {
                id = update.getCallbackQuery().getMessage().getChatId();
                if (id != null) {
                    return id;
                }
            } catch (RuntimeException e) {
                log.error("Не удалось получить айди через getCallbackQuery: " + e.getMessage());
            }
        }

        if (update.getMessage() != null) {
            try {
                id = update.getMessage().getChatId();
                if (id != null) {
                    return id;
                }
            } catch (RuntimeException e) {
                log.error("Не удалось получить айди через getMessage: " + e.getMessage());
            }
        }

        return id;
    }

    public void deleteLastBotMessage(Long chatId, Integer messageId) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(chatId.toString());
        deleteMessage.setMessageId(messageId);

        telegramBot.sendMessage(deleteMessage);
    }
}
