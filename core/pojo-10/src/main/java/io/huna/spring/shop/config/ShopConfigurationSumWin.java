package io.huna.spring.shop.config;

import io.huna.spring.shop.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({ "summer", "winter" })
@ComponentScan("io.huna.spring.shop")
public class ShopConfigurationSumWin {

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

    @Bean
    public Product dvdrw() {
        Disk p2 = new Disk("DVD-RW", 3.0);
        p2.setCapacity(700);
        return p2;
    }

}
