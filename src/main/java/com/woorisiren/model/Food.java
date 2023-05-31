package com.woorisiren.model;

import com.woorisiren.io.Console;

public class Food extends Item {

    private final boolean canWarm;
    private boolean toWarm;
    private String ment;

    public Food(String name, int price, boolean canWarm) {
        super(name, price);
        this.canWarm = canWarm;
    }

    @Override
    public void setOptions() {
        if (!canWarm) {
            return;
        }
        int option = 0;
        while (true) {
            Console.print("데워드릴까요? (1 or 2 // 1: Yes, 2: No): ");
            option = validate(Console.read());
            if (option != 0) {
                break;
            }
            Console.println("다시 입력해주세요");
        }
        this.toWarm = option == 1;
        this.ment = option == 1 ? "데워드리겠습니다" : "데우지 않고 드리겠습니다";
    }

    @Override
    public void printInfo() {
        Console.println(String.format("주문하신 음식은 %s 이고 가격은 %d원 음식은 %s", this.name, this.price, this.ment));
    }

}
