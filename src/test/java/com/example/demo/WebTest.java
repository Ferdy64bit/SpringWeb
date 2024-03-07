package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
@SpringBootTest
@AutoConfigureMockMvc
public class WebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void noParameter() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello akang"))
                );
    }
    @Test
    void mustParameter() throws Exception {
        mockMvc.perform(get("/hello").queryParam("name","ferdy"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello ferdy"))
                );
    }

    @Test
    void requestContenTypeTest() throws Exception {
        mockMvc.perform(
                post("/uhuy")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name","otoy")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello otoy"))
        );
    }

    @Test
    void dasa() {
       Date date = new Date();
       String a = date.toString();
        System.out.println(a);

    }
}
