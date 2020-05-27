package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.concrete;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.abst.Button;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.abst.Textarea;

public class FactoryInstance {
    public static GuiFactory getGuiFactory() {
        String osName = System.getProperty("os.name");
        if ("Window".equals(osName)) {
            return new WindowGuiFactory();
        } else if ("Mac".equals(osName)) {
            return new MacGuiFactory();
        } else if ("Linux".equals(osName)) {
            return new LinuxGuiFactory();
        }
        return new WindowGuiFactory();
    }

    private static class LinuxButton implements Button {
        @Override
        public void click() {
            System.out.println("This Button is for Linux.");
        }
    }

    private static class LinuxGuiFactory implements GuiFactory {
        @Override
        public Button createButton() {
            return new LinuxButton();
        }

        @Override
        public Textarea createTextarea() {
            return new LinuxTextarea();
        }
    }

    private static class LinuxTextarea implements Textarea {
        @Override
        public String getTextarea() {
            return "Text for Linux.";
        }
    }

    private static class WindowButton implements Button {
        @Override
        public void click() {
            System.out.println("This Button is for Window.");
        }
    }

    private static class WindowGuiFactory implements GuiFactory {
        @Override
        public Button createButton() {
            return new WindowButton();
        }

        @Override
        public Textarea createTextarea() {
            return new WindowTextarea();
        }
    }

    private static class WindowTextarea implements Textarea {
        @Override
        public String getTextarea() {
            return "Text for Window.";
        }
    }

    private static class MacButton implements Button {
        @Override
        public void click() {
            System.out.println("This Button is for Mac.");
        }
    }

    private static class MacGuiFactory implements GuiFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Textarea createTextarea() {
            return new MacTextarea();
        }
    }

    private static class MacTextarea implements Textarea {
        @Override
        public String getTextarea() {
            return "Text for Mac.";
        }
    }
}
