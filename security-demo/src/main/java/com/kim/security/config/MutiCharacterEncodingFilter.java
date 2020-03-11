package com.kim.security.config;

import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther KIM
 * @date 2018/12/3
 * @Description:
 */
public class MutiCharacterEncodingFilter extends CharacterEncodingFilter implements Ordered {
    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }

    private String mutiCharset = "GBK";

    public String getMutiCharset() {
        return mutiCharset;
    }

    public void setMutiCharset(String mutiCharset) {
        this.mutiCharset = mutiCharset;
    }

    public MutiCharacterEncodingFilter(String encoding, String mutiCharset, boolean forceRequestEncoding, boolean forceResponseEncoding, int loneconfigid) {
        super(encoding, forceRequestEncoding, forceResponseEncoding);
        this.mutiCharset = mutiCharset;
    }

    public MutiCharacterEncodingFilter() {
        super();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.startsWith("/user")) {
            try {
                if (mutiCharset != null) {
                    if (isForceRequestEncoding() || request.getCharacterEncoding() == null) {
                        request.setCharacterEncoding(mutiCharset);
                    }
                    if (isForceResponseEncoding()) {
                        response.setCharacterEncoding(mutiCharset);
                    }
                }
                filterChain.doFilter(request, response);
                return;
            } catch (NumberFormatException e) {

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        super.doFilterInternal(request, response, filterChain);
    }
}
