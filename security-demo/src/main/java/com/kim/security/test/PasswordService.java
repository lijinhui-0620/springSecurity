package com.kim.security.test;

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
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PasswordService {

    @Autowired
    private UserService userService;

    public PasswordService(UserService userService) {
        this.userService = userService;
    }

    public PasswordService() {
    }


    @Override
    public String toString() {
        return "PasswordService{" +
                "userService=" + (userService == null) +
                '}';
    }
}
