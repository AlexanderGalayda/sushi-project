package com.example.SUSHI.controller;

import com.example.SUSHI.domain.User;
import com.example.SUSHI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){


        if(!userService.addUser(user)){
            model.put("sushi","User Exists!");
            return "registration";
        }
        return "redirect:/login";
    }
    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){

        boolean isActivated = userService.activateUser(code);

        if(isActivated){
            model.addAttribute("sushi", "User successfully activated!");
        }
        else{
            model.addAttribute("sushi", "Activation code is not found!");
        }

        return "login";
    }
}
