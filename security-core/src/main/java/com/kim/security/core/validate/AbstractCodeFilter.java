package com.kim.security.core.validate;

import com.kim.security.core.properties.SecurityProperties;
import com.kim.security.core.validate.image.ImageCode;
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
 * @create: 2019-09-27 12:47
 * @description: 校验验证码 过滤器的 父类 TODO 给url增加类型  根据类型区分时要进行sms校验还是image校验
 */
public abstract class AbstractCodeFilter<C extends ValidateCode> extends OncePerRequestFilter implements InitializingBean {
    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    protected Set<String> urls = new HashSet<>();

    private SecurityProperties securityProperties;
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] strings = org.apache.commons.lang3.StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(), ",");
        for (String s : strings) {
            urls.add(s);
        }
        addSpecificUrl();
    }

    /**
     * @Description: 增加特有的url
     * @Param: []
     * @return: void
     * @Author: kim
     * @Date: 2019/9/27
     */
    protected abstract void addSpecificUrl();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean action = isMacth(request);

        if (action && request.getMethod().equalsIgnoreCase("POST")) {
            try {
                validate(new ServletWebRequest(request, response));
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    protected void validate(ServletWebRequest request) throws ValidateCodeException, ServletRequestBindingException {
        C c = (C) sessionStrategy.getAttribute(request, ValidateCodeProecssor.SESSION_KEY_PREFIX + getPramName());
        if (c == null) {
            throw new ValidateCodeException("验证码不存在");
        }
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), getPramName() + "Code");
        if (codeInRequest == null) {
            throw new ValidateCodeException("验证码能为空");
        }
        if (c.isExpired()) {
            throw new ValidateCodeException("验证码已经过期");
        }
        if (!StringUtils.equalsIgnoreCase(c.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(request, ValidateCodeProecssor.SESSION_KEY_PREFIX + getPramName());
    }

    protected abstract String getPramName();

    private boolean isMacth(HttpServletRequest request) {
        boolean action = false;
        for (String url : urls) {
            if (pathMatcher.match(url, request.getRequestURI())) {
                action = true;
                break;
            }
        }
        return action;
    }


    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }


    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
