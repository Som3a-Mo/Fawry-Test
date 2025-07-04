package model;

import interfaces.Shippable;

public class Electronics extends Product implements Shippable {
    private double weight;

    public Electronics(String name, double price, double quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
