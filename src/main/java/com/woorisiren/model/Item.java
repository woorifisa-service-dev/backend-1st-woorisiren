package com.woorisiren.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Item {

    protected final String name;
    protected final int price;

    public abstract void setOptions();
    public abstract void printInfo(int count);

    @Override
    public String toString() {
        return String.format("%s, %d원", name, price);
    }

    protected int validate(String s) {
        if (!(s.equals("1") || s.equals("2"))) {
            return 0;
        }
        return Integer.parseInt(s);
    }

}
