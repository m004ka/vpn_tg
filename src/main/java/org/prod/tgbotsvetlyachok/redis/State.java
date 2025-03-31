package org.prod.tgbotsvetlyachok.redis;

import lombok.Getter;

@Getter
public enum State {
    NORMAL("Normal"),
    GET_MAIL("GetMail");

    private String text;
    State(String text){
        this.text = text;
    }
}
