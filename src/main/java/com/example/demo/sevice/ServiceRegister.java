package com.example.demo.sevice;

import com.example.demo.BaseComponent.implComponnentEntity.ImpLogin;
import com.example.demo.BaseComponent.implComponnentEntity.ImplRegister;
import com.example.demo.BaseComponent.implComponnentEntity.User;
import com.example.demo.BaseComponent.repository.ImplLoginRepo;
import com.example.demo.BaseComponent.repository.UserRepo;
import com.example.demo.BaseComponent.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegister {

    @Autowired
    private RegisterRepo registerRepo;
    @Autowired
    private ImplLoginRepo implLoginRepo;
    @Autowired
    private UserRepo userRepo;
    public Boolean exapxitioHendler(ImplRegister register){
        if (registerRepo.existsById(register.getEmail())){
            return false;
        }else {
            return true;
        }
    }

    public Boolean getNotempty(String firtName,
                               String lastName,
                               String email,
                               String phone){
        if (firtName.isEmpty() || lastName.isEmpty()
        || email.isEmpty() || phone.isEmpty()){
            return false;
        }
        return true;
    }

    public void saveData(ImplRegister register,
                         ImpLogin impLogin, User user){


        registerRepo.save(register);
        userRepo.save(user);
        implLoginRepo.save(impLogin);

    }

    public Integer geOtp(){
        double min=0000;
        double max = 9999;
        double range = max-min+1;
        int key = 0;
        key = (int) (Math.random()*range)+(int) min;
        return key;
    }

}
