package io.huna.spring.shop;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Disk extends Product {

    private int capacity;

    public Disk() {
        super();
    }

    public Disk(String name, double price) {
        super(name, price);
    }

    public Disk(String name, double price, double discount) {
        super(name, price, discount);
    }

}
