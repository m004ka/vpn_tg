package org.prod.tgbotsvetlyachok.service.front.messages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prod.tgbotsvetlyachok.bot.Period;
import org.prod.tgbotsvetlyachok.bot.TelegramBot;
import org.prod.tgbotsvetlyachok.dto.PaymentDTO;
import org.prod.tgbotsvetlyachok.redis.Prefix;
import org.prod.tgbotsvetlyachok.redis.RedisService;
import org.prod.tgbotsvetlyachok.redis.State;
import org.prod.tgbotsvetlyachok.service.front.keyBoards.BuyKeyBoardService;
import org.prod.tgbotsvetlyachok.service.front.MessageService;
import org.prod.tgbotsvetlyachok.service.front.keyBoards.KeyBoardService;
import org.prod.tgbotsvetlyachok.service.front.text.BuyTextMessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuyMessages {
    private final TelegramBot telegramBot;

    private final MessageService messageService;

    private final BuyTextMessageService text;
    private final KeyBoardService keyBoardService;

    private final BuyKeyBoardService keyBoard;
    private final RedisService redisService;

    public void mailMessage(Update update, Boolean check){
        String mail = update.getMessage().getText();
        redisService.saveData(Prefix.MAIL.getText() + messageService.getChatId(update), mail);
        log.info("Данные сохранения в редис - id " + messageService.getChatId(update) + " mail " + mail );
        log.info("В пеймент месседж с чеком ушли");
        paymentUrlMessage(update, check);
    }


    public void priceMessage(Update update){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.priceMessageText(id));
        message.setReplyMarkup(keyBoard.getBuyMarkup());

        telegramBot.sendMessage(message);
    }

    public void startBuyMessage(Update update, Period period){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        redisService.saveData(Prefix.PERIOD.getText() + id, period.getText());

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.startBuyMessageText());
        message.setReplyMarkup(keyBoard.checkKeyBoard());

        telegramBot.sendMessage(message);
    }

    public void getMailMessage(Update update){
        log.info("В мейл месседж дошли");
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        redisService.saveData(Prefix.MAIL.getText() + id, State.GET_MAIL.getText());

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("HTML");
        message.setText(text.getMailMessageText());
        message.setReplyMarkup(keyBoard.backKeyBoard());

        telegramBot.sendMessage(message);
    }

    public void paymentUrlMessage(Update update, Boolean check){
        SendMessage message = new SendMessage();
        Long id = messageService.getChatId(update);
        String mail = redisService.getData(Prefix.MAIL.getText() + messageService.getChatId(update));
        String period = redisService.getData(Prefix.PERIOD.getText() + messageService.getChatId(update));
        redisService.saveData(Prefix.MAIL.getText() + id, State.NORMAL.getText());
        message.setChatId(id);
        message.setParseMode("HTML");
        message.setText(text.paymentMessageText(update, Period.getPeriodByString(period), check, mail));
        message.setReplyMarkup(keyBoardService.backKeyBoard());

        telegramBot.sendMessage(message);
    }

    public void successfulPaymentMessage(PaymentDTO paymentDTO){
        SendMessage message = new SendMessage();

        message.setChatId(paymentDTO.getTelegramUserId());
        message.setParseMode("HTML");
        message.setText(text.successfulPaymentText(paymentDTO));

        telegramBot.sendMessage(message);
    }
}
