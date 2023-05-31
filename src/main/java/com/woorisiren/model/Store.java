package com.woorisiren.model;

import java.time.LocalTime;
import lombok.Getter;

@Getter
public class Store {
    private final String name;
    private final String location;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Store(String name, String location, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format(
            "가게 명: %s, 위치 : %s, 운영 시각 : %s ~ %s", name, location, startTime.toString(), endTime.toString()
        );
    }

}