package org.prod.tgbotsvetlyachok.service.front.messages;

import lombok.RequiredArgsConstructor;
import org.prod.tgbotsvetlyachok.client.BackendClient;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class KeyMessages {

    private final BackendClient backendClient;

    public void getKeyMessage(Update update){

    }
}
