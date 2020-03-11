package com.kim.security.dto;

/**
 * @auther: kim
 * @create: 2019-09-24 11:46
 * @description:
 */
public class FileInfo {
    String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
