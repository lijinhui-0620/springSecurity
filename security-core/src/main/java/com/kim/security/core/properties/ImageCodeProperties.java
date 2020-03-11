package com.kim.security.core.properties;

/**
 * @auther: kim
 * @create: 2019-09-27 11:22
 * @description:
 */
public class ImageCodeProperties extends CodeProperties {
    private int width = 60;
    private int height = 50;

    public ImageCodeProperties() {
        setLength(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
