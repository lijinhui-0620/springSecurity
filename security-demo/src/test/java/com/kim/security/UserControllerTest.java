package com.kim.security;

import com.kim.security.browser.BrowserSecurityConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * @auther: kim
 * @create: 2019-09-21 15:13
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3)).andDo(print());

    }

    @Test
    public void info() throws Exception {
        mockMvc.perform(get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("tom"))
                .andDo(print());
    }

    @Test
    public void infoFail() throws Exception {
        mockMvc.perform(get("/user/as")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    public void createSuccess() throws Exception {
        String cotent = "{\"username\":\"张三\",\"password\":\"123456\",\"ppp\":\"adwewe131\",\"birthday\":" + new Date().getTime() + ",\"gender\":\"1\"}";
        mockMvc.perform(put("/user")
                .contentType("application/json;charset=GBK;")
                .content(cotent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andDo(print());
    }

    @Test
    public void updateSuccess() throws Exception {
        String cotent = "{\"username\":\"张三\",\"password\":\"123456\",\"ppp\":\"adwewe131\",\"birthday\":" + new Date().getTime() + "}";
        mockMvc.perform(post("/user")
                .param("username", "张三")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andDo(print());
    }


    @Test
    public void deleteSuccess() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }

    @Test
    public void uploadSuccess() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(fileUpload("/file")
                .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello upload".getBytes("utf-8")))
        )
                .andExpect(status().isOk())
                .andReturn().getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    public void contestTest() throws Exception{


        String[] beanDefinitionNames = wac.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }





}
