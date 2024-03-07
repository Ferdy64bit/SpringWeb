package com.example.demo;

import com.example.demo.BaseComponent.implComponnentEntity.ImplRegister;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JokoTest {
//    @Autowired
//    TestSaja testSaja;
    @Autowired
    private MockMvc mockMvc;

//    @Test
//    void asdadsa() {
//        Assertions.assertEquals("Hello akang", testSaja.hollow(null));
//        Assertions.assertEquals("Hello eko",testSaja.hollow("eko"));
//    }

    @Test
    void requestContenTypeTest() throws Exception {
        mockMvc.perform(
                post("/uhuy/123")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name","saya")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello saya"))
        );
    }

    @Test
    void headerTest() throws Exception {
        mockMvc.perform(
                get("/header")
                        .header("TOKEN","EKO")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK"))
        );
    }

    @Test
    void ImplRegisOke() {
        ImplRegister register = new ImplRegister();
        register.setEmail("");
        register.setPhone("");
        register.setFirstName("");

    }
}
