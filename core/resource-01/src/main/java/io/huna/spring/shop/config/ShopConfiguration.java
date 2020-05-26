package io.huna.spring.shop.config;

import io.huna.spring.shop.BannerLoader;
import io.huna.spring.shop.Battery;
import io.huna.spring.shop.Disk;
import io.huna.spring.shop.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:discounts.yml")
@ComponentScan("io.huna.spring.shop")
public class ShopConfiguration {

    @Value("${discount.endofyear:0}")
    private double specialEndofYearDiscountField;

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        // Setting to read the YAML file
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("discounts.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }

    @Bean
    public BannerLoader bannerLoader() {
        BannerLoader bl = new BannerLoader();
        bl.setBanner(banner);
        return bl;
    }

    @Bean
    public Product aaa() {
        Battery p1 = new Battery("AAA", 2.5, specialEndofYearDiscountField);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disk p2 = new Disk("CD-RW", 1.5, specialEndofYearDiscountField);
        p2.setCapacity(700);
        return p2;
    }

    @Bean
    public Product dvdrw() {
        Disk p2 = new Disk("DVD-RW", 3.0, specialEndofYearDiscountField);
        p2.setCapacity(700);
        return p2;
    }
}
