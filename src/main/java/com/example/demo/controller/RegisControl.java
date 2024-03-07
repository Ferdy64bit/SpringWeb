package com.example.demo.controller;

import com.example.demo.BaseComponent.implComponnentEntity.ImpLogin;
import com.example.demo.BaseComponent.implComponnentEntity.ImplRegister;
import com.example.demo.BaseComponent.implComponnentEntity.User;
import com.example.demo.sevice.MailOtp;
import com.example.demo.sevice.ServiceRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@Controller
public class RegisControl {
    @Autowired
    private ServiceRegister serviceRegister;

    @Autowired
    private MailOtp mailOtp;

    @Autowired
    private ImplRegister implRegister;

    private User usraja;

    @Autowired
    private ImpLogin impLogin;

    private String fullName;

    private int otp;


    @GetMapping(path = "/register")
    public String viewLogin(Model model, String msg ){

        model.addAttribute("msg",msg);
        return "regis";
    }


    @PostMapping(path = "/register/user",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getAddRegis( @RequestParam(name = "firstName") String firstName,
                               @RequestParam(name = "lastName") String lastname,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "phone") String phone){
        boolean mustTrue = serviceRegister.getNotempty(firstName,lastname,email,phone);
        if (!mustTrue){
            return "redirect:/register?msg=Mohon Maaf field tidak boleh kosong";
        }

        ImplRegister register = new ImplRegister();
        register.setFirstName(firstName);
        register.setLastName(lastname);
        register.setEmail(email);
        register.setPhone(phone);

        Date date = new Date();
        register.setTime(date.toString());

        Boolean isValid = serviceRegister.exapxitioHendler(register);
        implRegister = register;

        if (!isValid) {
            return "redirect:/register?msg=Mohon Maaf Email Yang Anda Gunakan Sudah Terdaftar";
        }

        return "redirect:/user";
    }



    @GetMapping(path = "/user")
    public String getSaveUsers(Model model){
        String name = implRegister.getFirstName() +" " + implRegister.getLastName();
        model.addAttribute("fullname",name);
        return "index";
    }

    @PostMapping(path = "/user/save")
    public String saveUser(@RequestParam(name = "name") String name,
                           @RequestParam(name = "hobby") String hobby,
                           @RequestParam(name = "addres") String addres,
                           @RequestParam(name = "password") String password){
        boolean must  = serviceRegister.getNotempty(name,password,hobby,addres);
        if (!must){
            return "redirect:/error";
        }
        fullName = name;

        User user = new User();
        user.setName(name);
        user.setHoby(hobby);
        user.setAlamat(addres);
        user.setEmail(implRegister.getEmail());
        user.setPhone(implRegister.getPhone());

        impLogin.setEmail(implRegister.getEmail());
        impLogin.setPassword(password);
        usraja = user;

        return "redirect:/message";
    }

    @GetMapping(path = "/message")
    public String getMessage(){
        otp = serviceRegister.geOtp();
        mailOtp.senEMail(implRegister.getEmail(),"WELCOME TO THE APP",
                "selemat bergabung dalam aplikasi kami" +
                        "semoga hari hari anda menyenangkan "+fullName+"dan bahagia saya tak tahu harus bagaimana tapi ini kode " +
                        "otp anda semoga menikmati layanan dan fasilitas di aplikasi kami " + otp);
        return "redirect:/otp";
    }


    @GetMapping(path = "/otp")
    public String senOtp(Model model,String msg){
        model.addAttribute("msg",msg);
        return "otp";
    }

    @PostMapping(path = "/input/otp")
    @ResponseBody
    public String getOtp(@RequestParam(name = "input1") String input1,
                         @RequestParam(name = "input2") String input2,
                         @RequestParam(name = "input3") String input3,
                         @RequestParam(name = "input4")String input4){
        String code = input1 + input2 + input3 + input4;
        if (!code.equalsIgnoreCase(String.valueOf(otp))){
            return "redirect:/otp?msg=Mohon Maaf Code Yang Anda Pasukan Salah.";
        }

        serviceRegister.saveData(implRegister,impLogin,usraja);
        String a = usraja.toString() + impLogin.toString();
        return a;
    }




    @GetMapping(path = "/kontol")
    public String tes (){
        return "tes";
    }


}
