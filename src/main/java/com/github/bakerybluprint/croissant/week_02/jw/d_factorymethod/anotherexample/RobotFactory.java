package com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.anotherexample;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 12:49 오전
 */
//팩토리클래스 (팩토리 메서드의 꽃!)
public abstract class RobotFactory {
    abstract Robot createRobot(String name);
}