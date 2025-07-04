package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartProduct> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void add(String productName, int quantity) {
        products.add(new CartProduct(productName, quantity));
    }

    public List<CartProduct> getProducts() {
        return products;
    }
}
