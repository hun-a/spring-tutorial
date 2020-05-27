package io.huna.spring;

import io.huna.spring.shop.Product;
import io.huna.spring.shop.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext("io.huna.spring");

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
    }

}
