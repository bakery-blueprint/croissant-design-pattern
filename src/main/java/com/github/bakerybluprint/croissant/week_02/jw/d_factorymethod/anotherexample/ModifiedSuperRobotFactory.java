package com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.anotherexample;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 12:48 오전
 */
public class ModifiedSuperRobotFactory extends RobotFactory {
    @Override
    Robot createRobot(String name) {
        try {
            Class<?> cls = Class.forName(name);
            Object obj = cls.newInstance();
            return (Robot)obj;
        } catch (Exception e) {
            return null;
        }
    }
}
