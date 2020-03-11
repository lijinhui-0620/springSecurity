package com.kim.security.core.social.qq.connet;

import com.kim.security.core.social.qq.api.QQ;
import com.kim.security.core.social.qq.api.impl.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @auther: kim
 * @create: 2019-09-28 11:15
 * @description:
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;
    private static final String URL_AUTHORIZEURL = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESSTOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, URL_AUTHORIZEURL, URL_ACCESSTOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(appId, accessToken);
    }
}
