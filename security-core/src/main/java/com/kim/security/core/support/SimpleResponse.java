package com.kim.security.core.support;

/**
 * @auther: kim
 * @create: 2019-09-25 12:14
 * @description:
 */
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
