package org.prod.tgbotsvetlyachok.service.front.text;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextMessageService {

    public String menuText(Long id, List<Long> time) {
        return
                "<b>Аккаунт ID </b>" + id + "\n\n<b>Ключ истекает через\n</b>" + time.get(0) + " дней " + time.get(1) + " часов " + time.get(2) + " минут ";
    }

    public String startText(Long id, List<Long> time) {
        return "✅ Доступ открыт ✅\n" + "<b>Аккаунт ID </b>" + id + "\n\n<b>Ключ истекает через\n</b>" + time.get(0) + " дней " + time.get(1) + " часов " + time.get(2) + " минут ";
    }

    public String defaultText(){
        return "Ознакомьтесь с нашим Главным меню, тут вы найдете ответ на ваш вопрос \uD83E\uDEF6\uD83C\uDFFC";
    }

}
