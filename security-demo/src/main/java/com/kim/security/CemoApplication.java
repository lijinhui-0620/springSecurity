package com.kim.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.Map;

/**
 * @auther: kim
 * @create: 2019-09-21 12:48
 * @description:
 */
@SpringBootApplication
@RestController
@EnableSwagger2
@EnableTransactionManagement
public class CemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "helloe psring security";
    }

}
