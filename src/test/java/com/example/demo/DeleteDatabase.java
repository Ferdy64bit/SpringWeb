package com.example.demo;

import com.example.demo.BaseComponent.implComponnentEntity.ImplRegister;
import com.example.demo.BaseComponent.repository.ImplLoginRepo;
import com.example.demo.BaseComponent.repository.ImplRegisterRepo;
import com.example.demo.BaseComponent.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteDatabase {
    @Autowired
    ImplRegister register;

    @Autowired
    private ImplRegisterRepo repo;

    @Autowired
    private ImplLoginRepo implLoginRepo;

    @Autowired
    private UserRepo userRepo;

    @Test
    void DeleteDatabase() {
        repo.deleteAll();
        implLoginRepo.deleteAll();
        userRepo.deleteAll();
    }
}
