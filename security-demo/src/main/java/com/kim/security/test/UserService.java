package com.kim.security.test;

import com.kim.security.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @auther: kim
 * @create: 2019-10-25 10:02
 * @description:
 */
@Service
public class UserService {

    @Autowired
    private PasswordService passwordService;

    public UserService(PasswordService passwordService) {
        this.passwordService = passwordService;
    }
    public UserService(){}

    @Override
    public String toString() {
        return "UserService{" +
                "passwordService=" + passwordService +
                '}';
    }
}
