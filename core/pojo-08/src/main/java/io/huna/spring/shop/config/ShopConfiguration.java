package io.huna.spring.shop.config;

import io.huna.spring.shop.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ComponentScan("io.huna.spring.shop")
public class ShopConfiguration {

    @Bean/*(initMethod = "openFile", destroyMethod = "closeFile")*/
    @DependsOn("preCashier")    // Cashier Bean will be created after PreCashier created
    public Cashier cashier() {
        String path = System.getProperty("java.io.tmpdir") + "/cashier";
        Cashier c1 = new Cashier();
        c1.setFileName("checkout");
        c1.setPath(path);
        return c1;
    }

    @Bean
    public PreCashier preCashier() {
        PreCashier cashier = new PreCashier();
        cashier.setName("PRE CASHIER");
        return cashier;
    }

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
