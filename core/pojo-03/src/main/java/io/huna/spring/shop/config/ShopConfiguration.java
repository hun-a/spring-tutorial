package io.huna.spring.shop.config;

import io.huna.spring.shop.Battery;
import io.huna.spring.shop.Disk;
import io.huna.spring.shop.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfiguration {

    @Bean
    public Product aaa() {
        Battery p1 = new Battery("AAA", 2.5);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disk p2 = new Disk("CD-RW", 1.5);
        p2.setCapacity(700);
        return p2;
    }
}
