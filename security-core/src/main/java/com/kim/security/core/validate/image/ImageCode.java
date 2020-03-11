package com.kim.security.core.validate.image;

import com.kim.security.core.validate.ValidateCode;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @auther: kim
 * @create: 2019-09-27 09:28
 * @description:
 */
public class ImageCode extends ValidateCode implements Serializable {


    transient private BufferedImage image;


    public ImageCode(BufferedImage image, String code, LocalDateTime expirTime) {
        super(code, expirTime);
        this.image = image;

    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


}
