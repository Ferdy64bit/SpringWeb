package com.example.demo;

import com.example.demo.BaseComponent.configuration.BaseConfiguration;
import com.example.demo.BaseComponent.implComponnentEntity.ImpLogin;
import com.example.demo.BaseComponent.repository.ImplLoginRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class LoginTest {
    @Autowired
    private  ImplLoginRepo repo;
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
    context =new AnnotationConfigApplicationContext(BaseConfiguration.class);
    context.registerShutdownHook();
    }

    @Test
    void LoginTest() {
        ImpLogin login = context.getBean(ImpLogin.class);
               login.setEmail("123");
               login.setPassword("123");

        Assertions.assertSame(login.getEmail(),"123");
        Assertions.assertSame(login.getPassword(),"123");
//        Assertions.assertTrue(login.succesLogin());
    }

    @Test
    void loginMustSame() {
        ImpLogin login = context.getBean(ImpLogin.class);
        ImpLogin login1 = context.getBean(ImpLogin.class);
        Assertions.assertSame(login,login1);
    }

    @Test
    void testCheckLogin() {
        ImpLogin impLogin = repo.findById("ferdyahmadwinata@gmail.com").orElse(null);
        System.out.println(impLogin.getEmail());
        System.out.println(impLogin.getPassword());
    }
}
