package com.github.bakerybluprint.croissant.week_03.sh.prototype2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cat navi = new Cat();
        navi.setName("navi");
        navi.setAge(new Age(2012, 3));

//        Cat yo = navi;
        Cat yo = navi.copy();
        yo.setName("yo");
//        yo.setAge(new Age(2013,2));
        yo.getAge().setYear(2013);
        yo.getAge().setValue(2);

//        System.out.println(navi.getName());
//        System.out.println(navi.getAge().getYear());
//        System.out.println(navi.getAge().getValue());
//
//        System.out.println(yo.getName());
//        System.out.println(yo.getAge().getYear());
//        System.out.println(yo.getAge().getValue());

        List<String> original = new ArrayList<>();

        original.add("apple");
        original.add("banana");

//        result = original;
        List<String> result = new ArrayList<>(original);
        result.add("cucumber");

        System.out.println(original.toString());

        System.out.println(result.toString());

    }
}
