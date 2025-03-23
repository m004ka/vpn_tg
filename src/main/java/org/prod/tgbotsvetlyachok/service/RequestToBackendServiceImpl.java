package org.prod.tgbotsvetlyachok.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class RequestToBackendServiceImpl implements RequestToBackendService{


    @Override
    public boolean checkUser(Update update) {
        return false;
    }
}
