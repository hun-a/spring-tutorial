package io.huna.spring.shop;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CashierKR extends Cashier {

    public CashierKR(MessageSource messageSource) {
        super(messageSource);
        this.locale = Locale.KOREAN;
    }

}
