package com.example.demo.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
 
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "homePage";
    }
 
     
    @RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
    public String contactusPage(Model model) {
        model.addAttribute("address", "Vietnam");
        model.addAttribute("phone", "...");
        model.addAttribute("email", "...");
        return "contactusPage";
    }

    @RequestMapping(value = { "/products" }, method = RequestMethod.GET)
    public String productsPage(Model model) {
        return "productsPage";
    }

    @RequestMapping(value = { "/users" }, method = RequestMethod.GET)
    public String usersPage(Model model) {
        return "usersPage";
    }
     
}