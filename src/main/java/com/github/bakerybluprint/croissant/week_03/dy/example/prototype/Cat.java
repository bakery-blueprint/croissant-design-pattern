package com.github.bakerybluprint.croissant.week_03.dy.example.prototype;

public class Cat implements Cloneable {

    public String name;
    public Age age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Cat copy() throws CloneNotSupportedException {

        Cat ret = (Cat)this.clone();
        ret.setAge(new Age(this.age.year, this.age.value)); // 명시적으로 깊은복사가 가능하도록함!
        return ret;
    }
}