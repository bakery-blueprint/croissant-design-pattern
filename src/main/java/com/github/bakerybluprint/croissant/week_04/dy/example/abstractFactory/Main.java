package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.BikeFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.Body;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.Wheel;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.sam.SamFactory;

public class Main {
    public static void main(String[] args) {

        // 자전거를 만드는 공장이 필요하고 공장마다 만들어줘야하는 자전거 부품, 만드는 방식이 다를때 팩토리 패턴 사용
        BikeFactory factory = new SamFactory();
        Body body = factory.createBody();
        Wheel wheel = factory.createWheel();
    }
}
