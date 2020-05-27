package io.huna.spring.shop.factory;

import io.huna.spring.shop.Product;
import lombok.Setter;
import org.springframework.beans.factory.config.AbstractFactoryBean;

@Setter
public class DiscountFactoryBean extends AbstractFactoryBean<Product> {

    private Product product;

    private double discount;

    @Override
    public Class<?> getObjectType() {
        return product.getClass();
    }

    @Override
    protected Product createInstance() throws Exception {
        product.setPrice(product.getPrice() * (1 - discount));
        return product;
    }

}
