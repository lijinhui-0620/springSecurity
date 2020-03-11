package com.kim.security.core.validate.sms;

import com.kim.security.core.properties.SecurityProperties;
import com.kim.security.core.validate.AbstractCodeFilter;
import com.kim.security.core.validate.sms.SmsCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @auther: kim
 * @create: 2019-09-27 11:13
 * @description:
 */
public class SmsCodeFilter extends AbstractCodeFilter<SmsCode> {


    @Override
    protected void addSpecificUrl() {
        urls.add("/authentication/mobile");
    }

    @Override
    protected String getPramName() {
        return "sms";
    }
}
