package io.huna.spring.shop;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor
public abstract class Product {

    private String name;

    private double originalPrice;

    private double price;

    public Product(String name, double price) {
        this(name, price, 0);
    }

    public Product(String name, double price, double discount) {
        this.name = name;
        this.originalPrice = price;
        this.price = price * (1 - discount);
    }
}
