package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.nhanvien;
import com.example.demo.Model.phongban;
import com.example.demo.Service.phongbanservice;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        String message = "Hello, me!";
        model.addAttribute("message", message);
        return "home";
    }

   
}
