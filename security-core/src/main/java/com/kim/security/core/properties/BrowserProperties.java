package com.kim.security.core.properties;

/**
 * @auther: kim
 * @create: 2019-09-25 12:20
 * @description:
 */
public class BrowserProperties {

    private String loginPage = "/singIn.html";

    private LoginType loginType = LoginType.JSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
