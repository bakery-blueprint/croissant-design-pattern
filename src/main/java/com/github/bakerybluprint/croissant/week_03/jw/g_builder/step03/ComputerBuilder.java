package com.github.bakerybluprint.croissant.week_03.jw.g_builder.step03;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:44 오후
 */
public class ComputerBuilder {

    private final String cpu;
    private final String ram;
    private final String storage;


    public static class Builder {
        private String cpu = "default";
        private String ram = "default";
        private String storage = "default";

        public Builder cpu(String val1) {
            cpu = val1;
            return this;
        }
        public Builder ram(String val2) {
            ram = val2;
            return this;
        }
        public Builder storage(String val3) {
            storage = val3;
            return this;
        }

        public ComputerBuilder build() {
            return new ComputerBuilder(this);
        }
    }

    public ComputerBuilder(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }


    @Override
    public String toString() {
        return "ComputerBuilder{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }
}
