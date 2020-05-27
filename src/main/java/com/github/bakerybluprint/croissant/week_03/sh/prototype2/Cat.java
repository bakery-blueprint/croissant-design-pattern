package com.github.bakerybluprint.croissant.week_03.sh.prototype2;

import lombok.Data;

@Data
public class Cat implements Cloneable {
    private String name;
    private Age age;

    public Cat copy() throws CloneNotSupportedException {
        Cat cat = (Cat) super.clone();
        cat.setAge(new Age(this.age.getYear(), this.age.getValue()));
        return cat;
    }
}
