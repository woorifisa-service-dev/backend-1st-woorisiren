package com.woorisiren.model;

import lombok.Getter;

public class User {

    @Getter
    private final String name;

    @Getter
    private int balance;

    private final Cart cart;

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public void addToCart(Item item, int count) {
        cart.add(item, count);
    }

    public void printOrderList() {
        cart.printList();
    }

    public Order pay() {
        int totalPrice = cart.getTotalPrice();
        if (totalPrice <= balance) {
            balance -= totalPrice;
            return Order.success(this.cart);
        }
        return Order.fail();
    }

}
