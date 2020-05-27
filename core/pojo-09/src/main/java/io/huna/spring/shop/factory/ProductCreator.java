package io.huna.spring.shop.factory;

import io.huna.spring.shop.Battery;
import io.huna.spring.shop.Disk;
import io.huna.spring.shop.Product;

import java.util.Map;

public class ProductCreator {

//    public static Product createProduct(String productId) {
//        if ("aaa".equals(productId)) {
//            return new Battery("AAA", 2.5);
//        } else if ("cdrw".equals(productId)) {
//            return new Disk("CD-RW", 1.5);
//        } else if ("dvdrw".equals(productId)) {
//            return new Disk("DVD-RW", 3.0);
//        }
//        throw new IllegalArgumentException("Unknown product");
//    }

    private Map<String, Product> products;

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public Product createProduct(String productId) {
        Product product = products.get(productId);
        if (product != null) {
            return product;
        }
        throw new IllegalArgumentException("Unknown product");
    }
}
