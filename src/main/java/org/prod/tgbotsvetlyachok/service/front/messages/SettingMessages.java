package org.prod.tgbotsvetlyachok.service.front.messages;

import lombok.RequiredArgsConstructor;
import org.prod.tgbotsvetlyachok.bot.TelegramBot;
import org.prod.tgbotsvetlyachok.service.front.MessageService;
import org.prod.tgbotsvetlyachok.service.front.keyBoards.KeyBoardService;
import org.prod.tgbotsvetlyachok.service.front.keyBoards.SettingsKeyBoardService;
import org.prod.tgbotsvetlyachok.service.front.text.SettingsTextMessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class SettingMessages {

    private final TelegramBot telegramBot;
    private final SettingsTextMessageService text;
    private final SettingsKeyBoardService keyBoard;
    private final KeyBoardService keyBoardService;
    private final MessageService messageService;

    public void settingsMessage(Update update){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.settingsText());
        message.setReplyMarkup(keyBoard.setupMarkup());

        telegramBot.sendMessage(message);
    }

    public void iphoneMessage(Update update){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.iphoneText());
        message.setReplyMarkup(keyBoardService.backKeyBoard());

        telegramBot.sendMessage(message);
    }

    public void androidMessage(Update update){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.androidText());
        message.setReplyMarkup(keyBoardService.backKeyBoard());

        telegramBot.sendMessage(message);
    }
    public void macMessage(Update update){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.macText());
        message.setReplyMarkup(keyBoardService.backKeyBoard());

        telegramBot.sendMessage(message);
    }
    public void windowsMessage(Update update){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.windowsText());
        message.setReplyMarkup(keyBoardService.backKeyBoard());

        telegramBot.sendMessage(message);
    }

    public void tvMessage(Update update){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.tvText());
        message.setReplyMarkup(keyBoardService.backKeyBoard());

        telegramBot.sendMessage(message);
    }
}
