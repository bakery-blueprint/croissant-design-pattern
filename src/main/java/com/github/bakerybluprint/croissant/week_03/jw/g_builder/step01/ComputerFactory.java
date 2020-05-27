package com.github.bakerybluprint.croissant.week_03.jw.g_builder.step01;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:06 오후
 */
public class ComputerFactory {

    private BluePrint bluePrint;

    public void setBlueprint(BluePrint blueprint) {
        this.bluePrint = blueprint;
    }

    public void make() {
        bluePrint.setRam();
        bluePrint.setCpu();
        bluePrint.setStorate();
    }

    public Computer getComputer() {
        return bluePrint.getComputer();
    }
}
