package com.fschmatz.falenciaPessoal.controller;

import java.util.*;
import com.fschmatz.falenciaPessoal.entity.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/error")
    public String erro() {
        return "error";
    }


    @GetMapping("/changelog")
    public String changelog() {
        return "changelog";
    }

    @GetMapping("/addCategoria")
    public String showForm(Model model) {
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);

        return "addCategoria";
    }

    @PostMapping("/addCategoria")
    public String submitForm(@ModelAttribute("user") Categoria categoria) {
        System.out.println(categoria);
        return "Foi? ..... ";
    }
}
