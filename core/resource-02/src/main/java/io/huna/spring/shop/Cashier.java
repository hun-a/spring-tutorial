package io.huna.spring.shop;

import org.springframework.context.MessageSource;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public abstract class Cashier {

    protected final MessageSource messageSource;

    protected Locale locale;

    public Cashier(MessageSource messageSource) {
        this.messageSource = messageSource;
        locale = Locale.getDefault();
    }

    public void checkout(ShoppingCart cart) throws IOException {
        String alert = messageSource.getMessage("alert.inventory.checkout", new Object[] { cart.getItems(), new Date() }, this.locale);
        System.out.println(alert);
    }


}
