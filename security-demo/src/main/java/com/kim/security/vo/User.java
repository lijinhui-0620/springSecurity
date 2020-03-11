package com.kim.security.vo;

import com.kim.security.ctrl.Gender;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Arrays;
import java.util.Date;

/**
 * @auther: kim
 * @create: 2019-09-21 15:24
 * @description:
 */
public class User {
    private String username;
    @NotBlank
    private String password;
    private char[] ppp;
    private int id;
    @Past
    private Date birthday;

    private Gender gender =Gender.MAIL;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public char[] getPpp() {
        return ppp;
    }

    public void setPpp(char[] ppp) {
        this.ppp = ppp;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ppp=" + Arrays.toString(ppp) +
                ", id=" + id +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }


}
