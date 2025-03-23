package org.prod.tgbotsvetlyachok.service;

import lombok.RequiredArgsConstructor;
import org.prod.tgbotsvetlyachok.bot.TelegramBot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final TelegramBot telegramBot;

    private final UpdateService updateService;

    private final KeyBoardService keyBoard;
    public void PaymentOptions(Update update){
        EditMessageText message = new EditMessageText();
        Long id = update.getCallbackQuery().getMessage().getChatId();
        int messId = update.getCallbackQuery().getMessage().getMessageId();
        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText("<b>Продли дни доступа выгодно</b>\uD83D\uDC47");
        message.setReplyMarkup(keyBoard.getBuyMarkup());
        telegramBot.sendMessage(message);
    }

    public void paymentUrl(Update update, Double value){
        EditMessageText message = new EditMessageText();
        Long id = update.getCallbackQuery().getMessage().getChatId();
        int messId = update.getCallbackQuery().getMessage().getMessageId();
        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(updateService.getUrl(update, value));
        message.setReplyMarkup(keyBoard.getBuyMarkup());
        telegramBot.sendMessage(message);
    }
}
