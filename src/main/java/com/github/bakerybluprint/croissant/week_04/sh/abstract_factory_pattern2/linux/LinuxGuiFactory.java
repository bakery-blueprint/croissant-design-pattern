package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.linux;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Button;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Textarea;

public class LinuxGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Textarea createTextarea() {
        return new LinuxTextarea();
    }
}
