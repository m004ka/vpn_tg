package org.prod.tgbotsvetlyachok.redis;

import lombok.Getter;


@Getter
public enum Prefix {
    PERIOD("period_"),
    MAIL("mail_");

    private String text;
    Prefix(String text){
        this.text = text;
    }
}
