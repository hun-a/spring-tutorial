package io.huna.spring.shop;

import lombok.*;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {

    private String name;

    private double price;
}
