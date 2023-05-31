package com.woorisiren.model;

import com.woorisiren.exception.BalanceException;
import com.woorisiren.io.Console;

public class Order {

    private final Cart cart;

    private Order(Cart cart) {
        this.cart = cart;
    }

    private Order() {
        this(null);
    }

    public static Order success(Cart cart) {
        return new Order(cart);
    }

    public static Order fail() {
        return new Order();
    }

    public void printResult() {
        Console.println();

        if (cart == null) {
            Console.println("잔액부족!!");
            throw new BalanceException();
        }

        Console.println("주문 성공! 빨리 찾으러 오세요!!!! \n");
        Console.println("=== 주문 내역 ===");
        cart.printList();
    }

}
