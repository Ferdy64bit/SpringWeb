package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginWebTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginWebTest() throws Exception {
        mockMvc.perform(
                post("/form/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email","123")
                        .param("password","123")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK"))
        );
    }

    @Test
    void loginWebTestFailed() throws Exception {
        mockMvc.perform(
                post("/form/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email","123")
                        .param("password","12323")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("FALSE"))
        );
    }
    @Test
    void regisWebTestFailed() throws Exception {
        mockMvc.perform(
                post("/regis/user")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("lastName","123")
                        .param("firstName","123")
                        .param("email", "123")
                        .param("phone","123")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("123"))
        );
    }

}
