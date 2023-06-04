package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.nhanvien;
import com.example.demo.Service.nhanvienService;
import com.example.demo.Service.phongbanservice;
import com.example.demo.repository.Inahnvienrepository;
import com.example.demo.repository.Iphongbanrepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/nhanvien")
public class NhanvienController {
    @Autowired
    private Inahnvienrepository inahnvienrepository;

    @Autowired
    private Iphongbanrepository iphongbanrepository;

    @Autowired
    private phongbanservice phongbanservice;
    @Autowired
    private nhanvienService nhanvienService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<nhanvien> nhanvien = nhanvienService.getALLNhanvien();
        model.addAttribute("nhanvien", nhanvien);
        model.addAttribute("title", " nhan vien ");
        return "nhanvien/list";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("nhanvien") nhanvien nhanvie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("phongban", phongbanservice.getAllphongban());
            model.addAttribute("nhanvien", nhanvie);
            model.addAttribute("title", "Add nahn vien");
            return "nhanvien/add";
        }

        nhanvienService.addNhanvien(nhanvie);
        return "redirect:/nhanvien";
    }
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("nhanvien", new nhanvien());
        model.addAttribute("phongban", phongbanservice.getAllphongban());
        model.addAttribute("title", "add nhan vien");
        return "nhanvien/add";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("title", "Edit nhan vien");
        model.addAttribute("phongban", phongbanservice.getAllphongban());
        nhanvien nhanviens = nhanvienService.getnhanvienbyid(id);
        if (nhanviens != null) {
            model.addAttribute("nhanvien", nhanviens);
            return "nhanvien/edit";

        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit/{id}")
    public String editBook( @PathVariable("id") String id,@Valid @ModelAttribute("nhanvien") nhanvien nhanVien,BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("phongban", phongbanservice.getAllphongban());
            model.addAttribute("nhanvien", nhanVien);
            model.addAttribute("title", "Edit nhanvien");
            return "nhanvien/edit";
        }
        nhanvienService.updateBook(nhanVien);
        return "redirect:/nhanvien";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id) {
        nhanvienService.deleteBook(id);
        return "redirect:/nhanvien";
    }
}
