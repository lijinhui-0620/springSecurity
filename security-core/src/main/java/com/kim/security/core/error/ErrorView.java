package com.kim.security.core.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.StringValueResolver;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @auther: kim
 * @create: 2019-11-10 21:50
 * @description:
 */
public class ErrorView implements View, EmbeddedValueResolverAware {
    private Resource resource;

    @Override
    public String getContentType() {
        return "text/html";
    }

    public ErrorView(Resource resource) {
        this.resource = resource;
    }

    private StringValueResolver stringValueResolver;
    private ObjectMapper objectMapper;

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        String viewStr = new String(FileCopyUtils.copyToByteArray(this.resource.getInputStream()), "utf-8");
        //根据model的数据  解析  viewStr
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }
}
