package com.example.demo;

import com.example.demo.BaseComponent.configuration.BaseConfiguration;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegisterTest {
    private ConfigurableApplicationContext context;


    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(BaseConfiguration.class);
        context.registerShutdownHook();
    }
//
//    @Test
//    void regisNotNull() {
//        Person person = context.getBean(Person.class);
//        Addres addres = context.getBean(Addres.class);
//        ImplRegister register = context.getBean(ImplRegister.class);
//
//        Assertions.assertNotNull(register);
//        Assertions.assertNotNull(person);
//        Assertions.assertNotNull(addres);
//    }
//
//    @Test
//    void regisSame() {
//        Person person = context.getBean(Person.class);
//        person.setEmail("123");
//        Addres addres = context.getBean(Addres.class);
//        addres.setMail("123");
//
//        ImplRegister register = context.getBean(ImplRegister.class);
//        register.setAddres(addres);
//        register.setPerson(person);
//
//        Assertions.assertSame(register.getAddres().getMail(),register.getPerson().getEmail());
//
//    }
//
//    @Test
//    void regisNotSame() {
//        Person person = context.getBean(Person.class);
//        person.setEmail("123");
//        Addres addres = context.getBean(Addres.class);
//        addres.setMail("143");
//
//        ImplRegister register = context.getBean(ImplRegister.class);
//        register.setAddres(addres);
//        register.setPerson(person);
//
//        Assertions.assertNotSame(register.getAddres().getMail(),register.getPerson().getEmail());
//
//    }
//
//    @Test
//    void regisSucces() {
//        Person person = context.getBean(Person.class);
//        person.setEmail("123");
//        Addres addres = context.getBean(Addres.class);
//        addres.setMail("123");
//        addres.setPhone("123");
//
//        ImplRegister register = context.getBean(ImplRegister.class);
//        register.setAddres(addres);
//        register.setPerson(person);
//
//
//        Assertions.assertTrue(register.isSuccesRegis("12345","12345"));
//
//    }
//
//    @Test
//    void regisNotSucces() {
//        Person person = context.getBean(Person.class);
//        person.setEmail("123");
//        Addres addres = context.getBean(Addres.class);
//        addres.setMail("123");
//        addres.setPhone("123");
//
//        ImplRegister register = context.getBean(ImplRegister.class);
//        register.setAddres(addres);
//        register.setPerson(person);
//
//
//        Assertions.assertFalse(register.isSuccesRegis("123","123"));
//
//    }
}
