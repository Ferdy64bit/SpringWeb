package com.example.demo.controller;

import com.example.demo.BaseComponent.implComponnentEntity.ImpLogin;
import com.example.demo.sevice.ServiceLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Controller
public class LoginWeb {

    @Autowired
    private ServiceLogin serviceLogin;

    @Autowired
    ObjectMapper objectMapper;


    @GetMapping(path = "/form")
    public String viwLogin(Model model,String msg){
        model.addAttribute("msg",msg);
        return "regis1";
    }

    @PostMapping(path = "/form/login" ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    public String loginWeb(@RequestParam("email") String email,
                           @RequestParam("password") String password){

        ImpLogin impLogin = serviceLogin.getAlready(email);

        if (impLogin == null){
            return "redirect:/form?msg=Email / Atau akun tidak terdaftar\"";
        }


        if (impLogin.getEmail().equalsIgnoreCase(email) &&
                impLogin.getPassword().equals(password)){
            return "tes";
        }

        return "redirect:/form?msg=Password / Email Yang Anda Pasukan Salah.\"";
    }


}
