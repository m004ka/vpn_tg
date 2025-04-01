package org.prod.tgbotsvetlyachok.service.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prod.tgbotsvetlyachok.dto.TelegramUserDTO;
import org.prod.tgbotsvetlyachok.redis.Prefix;
import org.prod.tgbotsvetlyachok.redis.RedisService;
import org.prod.tgbotsvetlyachok.redis.State;
import org.prod.tgbotsvetlyachok.service.front.MessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateOptionService {

    private final BackendService backendService;

    private final RedisService redisService;

    private final MessageService messageService;

    public void startOption(Update update){
        if(update.hasCallbackQuery() || update.hasMessage()  || update.hasInlineQuery() & update.getCallbackQuery() != null){
            TelegramUserDTO userDTO  = backendService.getUser(update.getMessage().getChatId());
            if(userDTO.getChatId() == null){
                backendService.createUser(TelegramUserDTO.toUserDTO(update));
                redisService.saveData(Prefix.MAIL.getText() + messageService.getChatId(update), State.NORMAL.getText());
                messageService.startMessage(update);
            }else {
                menuOption(update);
            }
        }
    }

    public void menuOption(Update update){
        messageService.menuMessage(update);
    }


}
