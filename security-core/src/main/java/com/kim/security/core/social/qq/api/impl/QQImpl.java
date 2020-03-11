package com.kim.security.core.social.qq.api.impl;

import com.kim.security.core.social.qq.api.QQ;
import com.kim.security.core.social.qq.api.QQUserInfo;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @auther: kim
 * @create: 2019-09-28 10:55
 * @description:
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;
    private String openId;


    public QQImpl(String appId, String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String result = getRestTemplate().getForObject(String.format(URL_GET_OPENID, accessToken), String.class);
        System.out.println(result);
        openId = StringUtils.substringBetween(result, "\"openid\"", "}");
    }

    @Override
    public QQUserInfo getUserInfo() {
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        return null;
    }
}
