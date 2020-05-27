package com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.anotherexample;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 12:50 오전
 */
public class SuperRobotFactory extends RobotFactory{

    @Override
    Robot createRobot(String name) {
        // TODO Auto-generated method stub
        switch (name) {
            case "super":
                return new SuperRobot();
            case "power":

                return new PowerRobot();
        }

        return null;
    }

}
