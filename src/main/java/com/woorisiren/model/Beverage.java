package com.woorisiren.model;

import com.woorisiren.io.Console;

public class Beverage extends Item {

    private static final String HOT = "HOT";
    private static final String ICE = "ICE";
    private static final String SMALL = "SMALL";
    private static final String LARGE = "LARGE";

    private String temperatureType;
    private String size;

    public Beverage(String name, int price) {
        super(name, price);
    }

    @Override
    public void setOptions() {
        setTemperatureType();
        setSize();
    }

    private void setTemperatureType() {
        // ice / hot 선택
        int option = 0;
        while (true) {
            Console.print("얼죽아?(1 or 2 // 1: Yes, 2:No): ");
            option = validate(Console.read());
            if (option != 0) {
                break;
            }
            Console.println("다시 입력해주세요");
        }
        if (option == 1) {
            this.temperatureType = ICE;
        } else {
            this.temperatureType = HOT;
        }
    }

    private void setSize() {
        // 1. small, 2. large
        int option = 0;
        while (true) {
            Console.print("사이즈를 입력해주세요 (1 or 2 // 1: Small, 2 : Large): ");
            option = validate(Console.read());
            if (option != 0) {
                break;
            }
            Console.println("다시 입력해주세요");
        }
        this.size = option == 1 ? SMALL : LARGE;

    }

    @Override
    public void printInfo(int count) {
        Console.println(
            String.format("%s %s %s %d개 %d원", this.temperatureType, this.name, this.size, count, this.price * count));
    }
}
