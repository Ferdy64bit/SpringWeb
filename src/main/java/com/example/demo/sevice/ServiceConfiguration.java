package com.example.demo.sevice;

import com.example.demo.BaseComponent.configuration.BaseConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceConfiguration {
    private static ConfigurableApplicationContext context;

    public static ConfigurableApplicationContext setUpConfigur(){
        context = new AnnotationConfigApplicationContext(BaseConfiguration.class);
        context.registerShutdownHook();
        return context;
    }
}
