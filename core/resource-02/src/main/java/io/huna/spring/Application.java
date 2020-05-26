package io.huna.spring;

import io.huna.spring.shop.Cashier;
import io.huna.spring.shop.Product;
import io.huna.spring.shop.ShoppingCart;
import io.huna.spring.shop.config.ShopConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

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

        Cashier usCashier = context.getBean("cashierUS", Cashier.class);
        usCashier.checkout(cart1);
        usCashier.checkout(cart2);

        Cashier krCashier = context.getBean("cashierKR", Cashier.class);
        krCashier.checkout(cart1);
        krCashier.checkout(cart2);
    }

}
