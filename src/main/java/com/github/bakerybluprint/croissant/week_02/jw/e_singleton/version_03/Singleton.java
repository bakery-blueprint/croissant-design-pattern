package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version_03;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/07
 * Time : 1:16 오전
 */

// TODO: [Double Checked Locking] junwoochoi 2020/05/07 1:18 오전
public class Singleton {
    private volatile static Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
