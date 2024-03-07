package com.example.demo.sevice;

import com.example.demo.BaseComponent.implComponnentEntity.ImpLogin;
import com.example.demo.BaseComponent.repository.ImplLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceLogin  {
    private static ConfigurableApplicationContext context;
    @Autowired
    private ImplLoginRepo repo;

    public ConfigurableApplicationContext setUpConfigur(){
        context = ServiceConfiguration.setUpConfigur();
        return context;
    }


    public ImpLogin  impLoginObject(){
        ImpLogin impLogin = context.getBean(ImpLogin.class);
        return impLogin;
    }

    public ImpLogin getAlready(String email){
    ImpLogin impLogin = repo.findById(email).orElse(null);
    return impLogin;
    }
}
