package com.github.bakerybluprint.croissant.week_03.dy.example.prototype;

import com.github.bakerybluprint.croissant.week_03.dy.example.prototype.Age;
import com.github.bakerybluprint.croissant.week_03.dy.example.prototype.Cat;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Cat navi = new Cat();
        navi.setName("navi");
        navi.setAge(new Age(2018, 2));

        Cat yo2 = navi.copy();
        yo2.setName("yo");
        yo2.getAge().setYear(2019);
        yo2.getAge().setValue(1);

        System.out.println(navi.getName());
        System.out.println(navi.getAge().getYear());    // yo의 year인 2019 출력 -> 깊은 복사가 이뤄지지않음.

        System.out.println(yo2.getName());              // 이름은 깊은복사 이루어짐!
        System.out.println(yo2.getAge().getYear());

    }
}