package org.prod.tgbotsvetlyachok.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prod.tgbotsvetlyachok.dto.PaymentDTO;
import org.prod.tgbotsvetlyachok.model.TelegramUser;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateService {

    private final RequestToBackendService request;

    private final TgCallbackService callbackService;

    private final MessageService messageService;


    public void updateOption(Update update){
        //todo Состояния чата
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            switch (messageText){
                case "/start":
                    if(request.checkUser(update)){
                        startCommand(update);
                    }else {
                        startCommandNewUser(update);
                    }
                    //todo Получение юзера добавление его на бэк или же проверка на существование
                    break;
                case "/pay":
                    messageService.PaymentOptions(update);
                    break;

                default:
                    break;

            }
        } else if (update.hasCallbackQuery()){
            callbackService.callbackOptions(update);
        } else {
            //TODO Ошибка
        }

    }

    private void startCommandNewUser(Update update){
        request.createUser(update);
        TelegramUser tgUser = request.takeUserById(userGetId(update));


    }

    private void startCommand(Update update){
        TelegramUser tgUser = request.takeUserById(userGetId(update));

    }

    public String getUrl(Update update, Double value){
       PaymentDTO payDTO = PaymentDTO.builder()
               .telegramUserId(userGetId(update))
               .mail("мимопока")
               .receipt(false)
               .value(value)
               .build();

       return request.getPaymentUrl(payDTO);
    }





    private Long userGetId(Update update){
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
}
