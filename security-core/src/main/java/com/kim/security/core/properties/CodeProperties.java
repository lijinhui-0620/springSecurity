package com.kim.security.core.properties;

/**
 * @auther: kim
 * @create: 2019-09-27 11:21
 * @description:
 */
public class CodeProperties {
    private int length = 6;
    private int expireIn = 60;
    private String url = "";

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
