package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.concreate;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.linux.LinuxGuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.mac.MacGuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.window.WindowGuiFactory;

public class FactoryInstance {

    public static GuiFactory getGuiFactory() {


        if (getOsCode() == 0) {
            return new MacGuiFactory();
        } else if (getOsCode() == 1) {
            return new WindowGuiFactory();
        } else if (getOsCode() == 2) {
            return new LinuxGuiFactory();
        }
        return null;
    }

    public static int getOsCode() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            return 0;
        } else if (System.getProperty("os.name").equals("Window")) {
            return 1;
        } else if (System.getProperty("os.name").equals("Linux")) {
            return 2;
        } else {
            return 3;
        }
    }
}
