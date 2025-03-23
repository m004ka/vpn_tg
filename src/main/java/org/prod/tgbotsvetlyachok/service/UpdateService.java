package org.prod.tgbotsvetlyachok.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class UpdateService {

    private final RequestToBackendService request;
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

            }
        } else if (update.hasCallbackQuery()){
            //TODO Каллбеки на кнопки
        } else {
            //TODO Ошибка
        }

    }

    private void startCommandNewUser(Update update){

    }

    private void startCommand(Update update){

    }
}
