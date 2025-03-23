package org.prod.tgbotsvetlyachok.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prod.tgbotsvetlyachok.config.BotConfig;
import org.prod.tgbotsvetlyachok.service.UpdateService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final UpdateService updateService;
    @Override
    public void onUpdateReceived(Update update) {
        updateService.updateOption(update);
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }


    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }

    }

    public void sendMessage(SendMessage textToSend) {
        try {
            execute(textToSend);
            System.out.println("не Ошибка");
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
            System.out.println("Ошибка");
        }

    }



    public void sendMessage(EditMessageText textToSend) {
        try {
            execute(textToSend);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }

    }

    public void sendMessage(SendPhoto textToSend) {
        try {
            execute(textToSend);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }

    }

    public void sendMessage(SendSticker textToSend) {
        try {
            execute(textToSend);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }

    }
}
