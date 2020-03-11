package com.kim.security.core.validate.image;


import com.kim.security.core.validate.AbstractCodeFilter;

/**
 * @auther: kim
 * @create: 2019-09-27 11:13
 * @description:
 */
public class ImageCodeFilter extends AbstractCodeFilter<ImageCode> {


    @Override
    protected void addSpecificUrl() {
        urls.add("/authentication/form");
    }

    @Override
    protected String getPramName() {
        return "image";
    }
}
