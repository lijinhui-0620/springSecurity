package com.kim.security.validator;

import org.springframework.util.AntPathMatcher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @auther: kim
 * @create: 2019-09-24 10:20
 * @description:
 */
public class MyConstrintValidator implements ConstraintValidator<MyConstraint, String> {
    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println(" my validator init...");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(s);
        return true;
    }

    public static void main(String[] args) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        System.out.println(antPathMatcher.match("45.*", "45.23.432.3"));
        int a = 10 >> 1;
        int b = a++;
        int c = ++a;
        int d = b * a++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        String x2 = new String("c") + new String("d");
        x2.intern();
        String x1 = "cd";
        System.out.println(x1 == x2);
//        new HashMap<>().put();
    }
}
