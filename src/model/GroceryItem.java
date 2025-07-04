package model;

import interfaces.Expirable;
import interfaces.Shippable;

public class GroceryItem extends Product implements Expirable, Shippable {
    private ExpirableProduct expirable;
    private double weight;

    public GroceryItem(String name, double price, double quantity,
                       String createdIn, int expireDays, double weight) {
        super(name, price, quantity);
        this.expirable = new ExpirableProduct(createdIn, expireDays);
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expirable.isExpired();
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
