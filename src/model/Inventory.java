package model;

import java.util.List;

public class Inventory {
    List<Product> products;

    public Inventory(List<Product> products) {
        this.products = products;
    }

    public Product getProduct(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
