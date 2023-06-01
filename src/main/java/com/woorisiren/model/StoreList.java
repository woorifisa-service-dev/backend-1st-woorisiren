package com.woorisiren.model;

import com.woorisiren.io.Console;
import java.time.LocalTime;
import java.util.List;

public class StoreList {

    private final List<Store> list;

    public StoreList() {
        this.list = getStoreList();
    }

    public Store getStore(int index) {
        return list.get(index - 1);
    }

    public void printStoreList() {
        for (int i = 1; i <= list.size(); i++) {
            Console.println(String.format("%d. %s", i, list.get(i - 1).toString()));
        }
    }

    private List<Store> getStoreList() {
        return List.of(new Store("스타벅스 상암 사보이시티점", "상암동 월드컵북로54길 17 사보이시티 DMC", LocalTime.of(10, 0),
                LocalTime.of(22, 0)),
            new Store("스타벅스 상암 MBC점", "성암로 267 ", LocalTime.of(10, 0),
                LocalTime.of(22, 0)),
            new Store("스타벅스 상암DMC점", "상암동 월드컵북로 375 DMC이안 상암 102호", LocalTime.of(10, 0),
                LocalTime.of(22, 0))
        );
    }

}
