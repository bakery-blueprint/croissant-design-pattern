package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.linux;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Textarea;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinuxTextarea implements Textarea {
    @Override
    public String getTextarea() {
        return "Text for Linux.";
    }
}
