package io.huna.spring;

import io.huna.spring.shop.Cashier;
import io.huna.spring.shop.Product;
import io.huna.spring.shop.ShoppingCart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        /**
         * AnotationConfigApplicationContext(basePackages...) call the refresh() that cause the exception,
         * so you should use the basic constructor when using the profile.
         *
         * Exception in thread "main" java.lang.IllegalStateException: GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once
         * 	at org.springframework.context.support.GenericApplicationContext.refreshBeanFactory(GenericApplicationContext.java:266)
         * 	at org.springframework.context.support.AbstractApplicationContext.obtainFreshBeanFactory(AbstractApplicationContext.java:637)
         * 	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:522)
         * 	at io.huna.spring.Application.main(Application.java:13)
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("global", "winter");
        context.scan("io.huna.spring.shop");
        context.refresh();  // IMPORTANT!!!

        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCart cart1 = context.getBean(ShoppingCart.class);
        cart1.addItem(aaa);
        cart1.addItem(cdrw);
        System.out.println(cart1);

        ShoppingCart cart2 = context.getBean(ShoppingCart.class);
        cart2.addItem(dvdrw);
        System.out.println(cart2);

        Cashier cashier = context.getBean(Cashier.class);
        cashier.checkout(cart1);
        cashier.checkout(cart2);
    }

}
