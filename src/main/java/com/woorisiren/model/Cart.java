package com.woorisiren.model;

import com.woorisiren.io.Console;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class Cart {

    private final Map<String, ItemCounter> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public void add(Item item, int count) {
        if (cart.containsKey(item.getName())) {
            cart.get(item.getName()).add(count);
        }

        cart.put(item.getName(), new ItemCounter(item, count));
    }

    public void printList() {
        for (String name : cart.keySet()) {
            cart.get(name).printInfo();
        }
    }

    public void printResult() {
        for (String name : cart.keySet()) {
            cart.get(name).printResult();
        }
    }

    public int getTotalPrice() {
        int sum = 0;
        for (String name : cart.keySet()) {
            sum += cart.get(name).getTotalPrice();
        }
        return sum;
    }

    static class ItemCounter {
        private final Item item;
        private int count;

        public ItemCounter(Item item, int count) {
            this.item = item;
            this.count = count;
        }

        public void add(int count) {
            this.count += count;
        }

        public void printInfo() {
            Console.println(String.format("%s, %d개", this.item.toString(), count));
        }

        public void printResult() {
            item.printInfo(count);
        }

        public int getTotalPrice() {
            return item.getPrice() * count;
        }
    }

}
