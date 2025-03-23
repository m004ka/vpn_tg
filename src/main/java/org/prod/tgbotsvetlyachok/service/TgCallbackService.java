package org.prod.tgbotsvetlyachok.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class TgCallbackService {

    private final MessageService messageService;

    public void callbackOptions(Update update){
        String callback = update.getCallbackQuery().getData();
        switch (callback){
            case "MONTHS":
                messageService.paymentUrl(update, 200.00);
                break;
            default:
                messageService.paymentUrl(update, 200.00);
                break;
        }
    };
}
