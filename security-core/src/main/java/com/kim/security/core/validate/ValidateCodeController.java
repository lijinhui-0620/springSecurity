package com.kim.security.core.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @auther: kim
 * @create: 2019-09-27 11:09
 * @description:
 */
@RestController
public class ValidateCodeController {
    @Autowired
    private Map<String, ValidateCodeProecssor> codeGeneratorMap;

    @GetMapping("/code/{type}")
    public void createCode(ServletWebRequest request, @PathVariable String type) throws Exception {
        codeGeneratorMap.get(type + "CodeProcessor").create(request);
    }

}
