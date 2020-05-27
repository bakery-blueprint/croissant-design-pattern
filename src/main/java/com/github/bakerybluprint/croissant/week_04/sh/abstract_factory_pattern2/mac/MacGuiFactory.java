package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.mac;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Button;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Textarea;

public class MacGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Textarea createTextarea() {
        return new MacTextarea();
    }
}
