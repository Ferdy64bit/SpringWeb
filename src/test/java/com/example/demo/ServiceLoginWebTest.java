package com.example.demo;

import com.example.demo.BaseComponent.implComponnentEntity.ImpLogin;
import com.example.demo.sevice.ServiceLogin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceLoginWebTest extends ServiceLogin{
    @Test
    void impLoginTest() {
        setUpConfigur();
        ImpLogin login = impLoginObject();
        ImpLogin login1 = impLoginObject();
        Assertions.assertSame(login1,login);
    }
}
