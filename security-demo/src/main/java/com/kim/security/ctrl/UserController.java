package com.kim.security.ctrl;

import com.kim.security.vo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: kim
 * @create: 2019-09-21 15:21
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/me")
    public Object getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PutMapping
    public User create(@RequestBody User user) {
        System.out.println(user);
        user.setId(1);
        return user;
    }

    @GetMapping
    @ApiOperation("用户查询服务")
    public List<User> query() {
        List<User> users = new ArrayList<>();

        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable("id") String id) {
        User user = new User();
        user.setUsername("tom");
        System.out.println("进入getInfo服务");
        return user;
    }

    @PostMapping
    public User update(ServletWebRequest request, HttpServletRequest req) throws ServletRequestBindingException, UnsupportedEncodingException {
        request.getResponse().setCharacterEncoding("GBK");
        String username = ServletRequestUtils.getStringParameter(request.getRequest(), "username");
        String s = new String(username.getBytes("UTF-8"), "UTF-8");
        System.out.println(s);
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}
