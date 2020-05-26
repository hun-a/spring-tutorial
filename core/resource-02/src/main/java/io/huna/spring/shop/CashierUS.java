package io.huna.spring.shop;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CashierUS extends Cashier {

    public CashierUS(MessageSource messageSource) {
        super(messageSource);
        this.locale = Locale.US;
    }

}
