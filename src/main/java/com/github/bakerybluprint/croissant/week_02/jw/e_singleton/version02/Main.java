package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version02;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/02
 * Time : 5:55 오후
 */
public class Main {
    public static void main(String[] args) {
        SystemSpeaker instance = SystemSpeaker.getInstance();
        System.out.println(instance);

        SystemSpeaker instance2 = SystemSpeaker.getInstance();
        SystemSpeaker instance3 = SystemSpeaker.getInstance();

        System.out.println(instance == instance2 ? true : false);


        instance.innerMethod();
    }
}
