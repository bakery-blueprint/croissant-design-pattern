package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/02
 * Time : 5:07 오후
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        SystemSpeaker instance1 = SystemSpeaker.getInstance();
        SystemSpeaker instance2 = SystemSpeaker.getInstance();



        Class<SystemSpeaker> systemSpeakerClass = SystemSpeaker.class;
        Constructor<SystemSpeaker> declaredConstructor = systemSpeakerClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SystemSpeaker instance3 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);
    }
}
