package com.example.SUSHI.controller;

import com.example.SUSHI.domain.NewSushi;


import com.example.SUSHI.domain.OrderSushi;
import com.example.SUSHI.domain.SushiSet;
import com.example.SUSHI.domain.User;
import com.example.SUSHI.repos.NewSushiRepos;

import com.example.SUSHI.repos.OrderRepos;
import com.example.SUSHI.repos.SushiSetRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private NewSushiRepos newSushiRepos;

    @Autowired
    private SushiSetRepos sushiSetRepos;
    @Autowired
    private OrderRepos orderRepos;

    @Value("${upload.path}")
    private String uploadPath;




    @GetMapping("/")
    public String greeting(Map<String,Object> model) {

        return "greeting";
    }










    @GetMapping("/author")
    public String auth(@RequestParam(required = false, defaultValue = "") String filter,  Model model)
    {
        Iterable<NewSushi>newSushis = newSushiRepos.findAll();
        if(filter!=null && !filter.isEmpty()){
            newSushis=newSushiRepos.findByName(filter);
        }
        else{
            newSushis=newSushiRepos.findAll();
        }
       // model.addAttribute("username", user.getUsername());
        model.addAttribute("sushi", newSushis);
        model.addAttribute("filter", filter);
        return "author";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,  Model model)
    {

        Iterable<NewSushi>newSushis = newSushiRepos.findAll();
        if(filter !=null && !filter.isEmpty()) {
            newSushis = newSushiRepos.findByName(filter);
        }
        else {
            newSushis = newSushiRepos.findAll();
        }

        model.addAttribute("sushi", newSushis);
        model.addAttribute("filter", filter);
        return "main";
    }









///////////////////////////////////////
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam int weight,
            @RequestParam String description, Map<String,Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        NewSushi newSushi = new NewSushi(name,price,weight,description);
        if(file!=null && !file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists())
            {
                uploadDir.mkdir();
            }
            else{
                System.out.println("error1");
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile+"."+file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/"+resultFilename));
            newSushi.setFilename(resultFilename);
        }
        newSushiRepos.save(newSushi);

        Iterable<NewSushi>newSushis = newSushiRepos.findAll();
        model.put("sushi", newSushis);
        model.put("filter", "");
        return "main";
    }




    @GetMapping("/orders")
    public String addOrder(Model model){

        return "orders";
    }


@GetMapping("/order")
public String order(  Model model,@AuthenticationPrincipal User user){


    Iterable<OrderSushi>orders = orderRepos.findAll();

    model.addAttribute("order", orders);
    return "order";
}

    @PostMapping("/order")
    public String addOrder(
            @AuthenticationPrincipal User user,
            @RequestParam int phone,
            @RequestParam String address,
            @RequestParam String additional, Map<String,Object> model

    ){
        OrderSushi order = new OrderSushi( phone, address,additional);

        orderRepos.save(order);
        Iterable<OrderSushi>orders = orderRepos.findAll();

        model.put("order", orders);
        return "order";
    }


    @GetMapping("/sushiSet")
    public String sushiSet(@RequestParam(required = false, defaultValue = "") String filter, Model model)
    {
        Iterable<SushiSet>sushiSets = sushiSetRepos.findAll();
        if(filter!=null && !filter.isEmpty()){
            sushiSets=sushiSetRepos.findByName(filter);
        }
        else{
            sushiSets=sushiSetRepos.findAll();
        }

        model.addAttribute("sushiSet", sushiSets);
        model.addAttribute("filter", filter);
        return "sushiSet";
    }

    @PostMapping("/sushiSet")
    public String addSushiSet(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam int weight,
            @RequestParam int amountPiece,
            @RequestParam String consist, Map<String,Object> model,
            @RequestParam("file") MultipartFile file

    ) throws IOException {
        SushiSet sushiSet = new SushiSet(name, price,  weight, amountPiece, consist);

        if(file!=null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            else{
                System.out.println("Error2");
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            sushiSet.setFilename(resultFilename);
        }

            sushiSetRepos.save(sushiSet);
            Iterable<SushiSet>sushiSets = sushiSetRepos.findAll();
            model.put("sushiSet", sushiSets);
            model.put("filter", "");

        return "sushiSet";
    }


}