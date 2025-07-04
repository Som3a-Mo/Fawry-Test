package model;

public class CartProduct {
    private String Name;
    private int quantity;

    public CartProduct(String name, int quantity) {
        Name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return Name;
    }
    public int getQuantity() {
        return quantity;
    }
}
