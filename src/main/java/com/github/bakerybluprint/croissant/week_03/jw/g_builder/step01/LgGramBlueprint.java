package com.github.bakerybluprint.croissant.week_03.jw.g_builder.step01;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:05 오후
 */
public class LgGramBlueprint extends BluePrint{

    private String cpu;
    private String ram;
    private String storage;

    @Override
    public void setCpu() {
        this.cpu = "i7";
    }

    @Override
    public void setRam() {
        this.ram = "8g";
    }

    @Override
    public void setStorate() {
        this.storage = "256G SSD";
    }

    @Override
    public Computer getComputer() {
        return new Computer(cpu,ram,storage);
    }
}
