package com.woorisiren.model;

import com.woorisiren.io.Console;
import java.util.List;
import lombok.Getter;

@Getter
public class Menu {

    private final List<Item> menuList;

    public Menu() {
        this.menuList = makeMenuList();
    }

    public Item getItem(int itemNumber) {
        return menuList.get(itemNumber - 1);
    }

    private List<Item> makeMenuList() {
        return List.of(
            new Beverage("아메리카노", 4_500),
            new Beverage("카페 라떼", 5_000),
            new Beverage("바닐라 라떼", 5_500),
            new Food("7 레이어 가나슈 케이크", 5_500, false),
            new Food("쿠바 샌드위치", 6_900, true),
            new Food("쿠키", 3_000, false)
        );
    }

    public void printMenu() {
        int i = 1;
        for (Item item : menuList) {
            Console.print(String.format("%d. ", i++));
            Console.println(item);
        }
    }

}
