package com.fschmatz.falenciaPessoal.controller;

import java.util.*;
import com.fschmatz.falenciaPessoal.entity.Categoria;
import com.fschmatz.falenciaPessoal.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    CategoriaRepository catRepository;

    //PAGINA PRINCIPAL
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    //EXIBE A PAGINA DE GERENCIAR
    @RequestMapping(value="/falenciaPessoal/categorias/gerenciarCategorias", method=RequestMethod.GET)
    public String gerenciarCategorias(){
        return "gerenciarCategorias.html";
    }

    //EXIBE A PAGINA DE ADD
    @RequestMapping(value="/falenciaPessoal/categorias/addCategoria", method=RequestMethod.GET)
    public String addCategoria(){
        return "addCategoria.html";
    }

    //LISTAGEM
    @RequestMapping("/falenciaPessoal/categorias")
    public ModelAndView listarCategoria(){
        ModelAndView mv = new ModelAndView("listarCategoria");
        Iterable<Categoria> categorias = catRepository.findAll();
        mv.addObject("categorias", categorias);
        return mv;
    }





    @RequestMapping("/falenciaPessoal/categorias/delete/{id}")
    public String deletarCategoria(@PathVariable("id") Integer codigo){
        catRepository.deleteById(codigo);
        return "redirect:/falenciaPessoal/categorias";
    }

    @RequestMapping(value="/falenciaPessoal/categorias/edit/{id}",method = RequestMethod.GET)
    public ModelAndView detalhesCategoria(@PathVariable("id") Integer codigo){
        ModelAndView mv = null;
        Optional<Categoria> categoria = catRepository.findById(codigo);
        if(categoria.isPresent()){
            mv = new ModelAndView("editCategoria");
            mv.addObject("categoria", categoria.get());
        }

        return mv;
    }

    @RequestMapping("/falenciaPessoal/categorias/edit/{id}")
    public String editarCategoria(@PathVariable("id") Integer id, @Validated Categoria categoria, BindingResult result, Model model){

        Optional<Categoria> existingCategoriaOptional = catRepository.findById(id);
        if (existingCategoriaOptional.isPresent()) {
            Categoria categoriaSalva = existingCategoriaOptional.get();
            BeanUtils.copyProperties(categoria, categoriaSalva, "id_categoria");
            catRepository.save(categoriaSalva);
        }

        return "redirect:/falenciaPessoal/categorias";
    }













    //Funcionais paginas simples

    @GetMapping("/error")
    public String erro() {
        return "error";
    }

    @GetMapping("/changelog")
    public String changelog() {
        return "changelog";
    }
}
