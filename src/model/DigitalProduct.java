package model;

import interfaces.Expirable;

public class DigitalProduct extends Product implements Expirable {
    private ExpirableProduct expirable;

    public DigitalProduct(String name, double price, double quantity,
                          String createdIn, int expireDays) {
        super(name, price, quantity);
        this.expirable = new ExpirableProduct(createdIn, expireDays);
    }

    @Override
    public boolean isExpired() {
        return expirable.isExpired();
    }
}
