package org.prod.tgbotsvetlyachok.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface RequestToBackendService {
    public boolean checkUser(Update update);
}
