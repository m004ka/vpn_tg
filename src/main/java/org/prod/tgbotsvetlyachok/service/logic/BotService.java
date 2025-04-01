package org.prod.tgbotsvetlyachok.service.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prod.tgbotsvetlyachok.enums.Period;
import org.prod.tgbotsvetlyachok.redis.Prefix;
import org.prod.tgbotsvetlyachok.redis.RedisService;
import org.prod.tgbotsvetlyachok.redis.State;
import org.prod.tgbotsvetlyachok.service.front.MessageService;
import org.prod.tgbotsvetlyachok.service.front.messages.BuyMessages;
import org.prod.tgbotsvetlyachok.service.front.messages.DownloadMessages;
import org.prod.tgbotsvetlyachok.service.front.messages.KeyMessages;
import org.prod.tgbotsvetlyachok.service.front.messages.SettingMessages;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;


@Slf4j
@Service
@RequiredArgsConstructor
public class BotService {

    private final RedisService redisService;
    private final MessageService messageService;
    private final BuyMessages buyMessages;
    private final DownloadMessages downloadMessages;
    private final SettingMessages settingsMessages;
    private final UpdateOptionService updateOptionService;
    private final KeyMessages keyMessages;


    public void updateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (checkBotState(messageService.getChatId(update))) {
               buyMessages.mailMessage(update, true);
               log.info("Создаем получаем почту");
            } else {
                CallbackMessageSwitcher(update);
                log.info("Отправляем в свитчер");
            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuerySwitcher(update);
        } else {
            log.warn("Сообщение не содержит текст");
        }

    }

    private void CallbackMessageSwitcher(Update update) {
        String messageText = update.getMessage().getText();
        log.info("Получили текст " + messageText);

        switch (messageText) {
            case "/start":
                updateOptionService.startOption(update);
                break;
            case "\uD83C\uDFE0 Главное меню \uD83C\uDFE0":
                updateOptionService.menuOption(update);
                break;
            default:
                messageService.defaultMessage(update);
                break;
        }
    }

    private void CallbackQuerySwitcher(Update update) {
        String callbackData = update.getCallbackQuery().getData();
        log.warn("callback data = " + callbackData);
        switch (callbackData) {
            case "MENU":
                messageService.menuMessage(update);
                break;
            case "BUY":
                buyMessages.priceMessage(update);
                break;
            case "SETUP":
                settingsMessages.settingsMessage(update);
                break;
            case "KEY":
                keyMessages.getKeyMessage(update);
                break;
            case "MONTHS":
                buyMessages.startBuyMessage(update, Period.MONTH);
                break;
            case "THREEMONTHS":
                buyMessages.startBuyMessage(update, Period.THREE_MONTH);
                break;
            case "SIXMONTHS":
                buyMessages.startBuyMessage(update, Period.SIX_MONTH);
                break;
            case "YEAR":
                buyMessages.startBuyMessage(update, Period.YEAR);
                break;
            case "IPHONE":
                settingsMessages.iphoneMessage(update);
                break;
            case "ANDROID":
                settingsMessages.androidMessage(update);
                break;
            case "MAC":
                settingsMessages.macMessage(update);
                break;
            case "WIN":
                settingsMessages.windowsMessage(update);
                break;
            case "TV":
                settingsMessages.tvMessage(update);
                break;
            case "RECEIPT_TRUE":
                buyMessages.getMailMessage(update);
                break;
            case "RECEIPT_FALSE":
                buyMessages.paymentUrlMessage(update, false);
                break;
            case "DOWNLOAD":
                downloadMessages.downloadMessage(update);
                break;
            case "MENU_UPDATE":
                messageService.menuQuery(update);
                break;
            default:
                messageService.defaultMessage(update);
                break;
        }
    }




    private boolean checkBotState(Long id) {
        if(redisService.getData(Prefix.MAIL.getText() + id) == null){
            return false;
        }
        return redisService.getData(Prefix.MAIL.getText() + id).equals(State.GET_MAIL.getText());
    }
}
