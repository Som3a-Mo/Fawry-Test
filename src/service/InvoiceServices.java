package service;

import interfaces.Expirable;
import interfaces.Shippable;
import model.*;

import java.util.HashMap;

public class InvoiceServices {
    private static Inventory inventory;
    private static final double SHIPPING_FEE = 10;

    public static void setInventory(Inventory inv) {
        inventory = inv;
    }

    public static void checkout(Customer customer, Cart cart) {
        HashMap<Shippable, Double> toShip =  new HashMap<>();
        HashMap<Product, Double> toReceipt = new HashMap<>();
        for (CartProduct cp : cart.getProducts()) {
            Product p = inventory.getProduct(cp.getName());
            if (p == null) {
                System.out.printf("model.Product '%s' not found%n", cp.getName());
                continue;
            }
            if (p instanceof Expirable && ((Expirable)p).isExpired()) {
                System.out.printf("model.Product '%s' is expired%n", cp.getName());
                continue;
            }
            double quantity = cp.getQuantity();
            if (p.getQuantity() < quantity) {
                System.out.printf("'%s' is out of stock%n", cp.getName());
                continue;
            }
            if (p instanceof Shippable) {
                toShip.put((Shippable)p, quantity);
            }
            toReceipt.put(p, quantity);
        }
        CheckoutReceipt(customer, toReceipt, toShip);
    }

    private static void CheckoutReceipt(Customer customer, HashMap<Product, Double> allItems, HashMap<Shippable, Double> shippingItems) {

        double totalPrice = ShippingService.ship(shippingItems);
        System.out.println("** Checkout receipt **");

        double subtotal = 0;

        for (Product p : allItems.keySet()) {
            double quantity = allItems.get(p);
            double lineTotal = quantity * p.getPrice();
            subtotal += lineTotal;

            System.out.printf("%.0fx %s\t%.0f%n", quantity, p.getName(), lineTotal);
        }

        System.out.println("----------------------");

        double shipping =  totalPrice * SHIPPING_FEE;
        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            System.out.println("Not enough money");
            return;
        }
        customer.setBalance(customer.getBalance() - total);

        for (Product p : allItems.keySet()) {
            double quantity = allItems.get(p);
            p.reduceQuantity(quantity);
        }

        System.out.printf("Subtotal    %.0f%n", subtotal);
        System.out.printf("Shipping    %.0f%n", shipping);
        System.out.printf("Amount      %.0f%n", total);
    }

}
