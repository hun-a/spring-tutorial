package io.huna.spring.shop.config;

import io.huna.spring.shop.*;
import io.huna.spring.shop.factory.DiscountFactoryBean;
import io.huna.spring.shop.factory.ProductCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("io.huna.spring.shop")
public class ShopConfiguration {

    @Bean
    public ProductCreator productCreator() {
        ProductCreator factory = new ProductCreator();
        Map<String, Product> products = new HashMap<>();
        products.put("aaa", new Battery("AAA", 2.5));
        products.put("cdrw", new Disk("CD-RW", 1.5));
        products.put("dvdrw", new Disk("DVD-RW", 3.0));
        factory.setProducts(products);
        return factory;
    }

    @Bean
    public Product aaa() {
        return productCreator().createProduct("aaa");
    }

    @Bean
    public Product cdrw() {
        return productCreator().createProduct("cdrw");
    }

    @Bean
    public Product dvdrw() {
        return productCreator().createProduct("dvdrw");
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanAAA() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setProduct(aaa());
        factory.setDiscount(0.2);
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanCDRW() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setProduct(cdrw());
        factory.setDiscount(0.1);
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanDVDRW() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setProduct(dvdrw());
        factory.setDiscount(0.1);
        return factory;
    }

}
