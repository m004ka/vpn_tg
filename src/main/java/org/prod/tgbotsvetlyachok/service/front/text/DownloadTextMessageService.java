package org.prod.tgbotsvetlyachok.service.front.text;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DownloadTextMessageService {

    public String downloadText(){
        return "\uD83C\uDF89 *СКАЧАТЬ ПРИЛОЖЕНИЕ*\n" +
                "\n" +
                "Выберите Вашу операционную систему и скачайте соответствующее приложение ⬇\uFE0F";
    }
}
