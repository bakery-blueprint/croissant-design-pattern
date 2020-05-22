package com.github.bakerybluprint.croissant.week_03.sh.prototype2;

import lombok.Data;

@Data
public class Age {
    int year;
    int value;

    public Age(int year, int value) {
        this.year = year;
        this.value = value;
    }
}
