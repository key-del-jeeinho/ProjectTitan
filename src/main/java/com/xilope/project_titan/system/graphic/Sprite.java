package com.xilope.project_titan.system.graphic;

import java.awt.*;

public class Sprite {
    private final int width;
    private final int height;
    private final int[] pixels;
    private final boolean[] hitbox;

    private Sprite(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
        this.hitbox = new boolean[width * height];
    }

    public Sprite(Image img) {
        this(img.getWidth(), img.getHeight())
    }
}
