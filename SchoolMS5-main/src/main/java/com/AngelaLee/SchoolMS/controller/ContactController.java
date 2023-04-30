package com.AngelaLee.SchoolMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * controller for contact
 * */

@Controller
public class ContactController {

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("message", "Welcome to my home page!");
        return "contact";
    }
}