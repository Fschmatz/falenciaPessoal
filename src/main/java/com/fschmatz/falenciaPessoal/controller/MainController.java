package com.fschmatz.falenciaPessoal.controller;

import java.util.*;
import com.fschmatz.falenciaPessoal.entity.Categoria;
import com.fschmatz.falenciaPessoal.entity.Despesa;
import com.fschmatz.falenciaPessoal.entity.Receita;
import com.fschmatz.falenciaPessoal.repository.CategoriaRepository;
import com.fschmatz.falenciaPessoal.repository.DespesaRepository;
import com.fschmatz.falenciaPessoal.repository.ReceitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class MainController {

    CategoriaRepository catRepository;
    DespesaRepository despRepository;
    ReceitaRepository recRepository;

    //LOGIN
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //PAGINA PRINCIPAL
    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/falenciaPessoal")
    public String home() {
        return "home";
    }


    //PAGINAS SIMPLES
    @GetMapping("/error")
    public String erro() {
        return "error";
    }

    @GetMapping("/changelog")
    public String changelog() {
        return "changelog";
    }



    //------------------ HTML CATEGORIAS

    @RequestMapping("/falenciaPessoal/categorias")
    public ModelAndView listarCategoria(){
        ModelAndView mv = new ModelAndView("listarCategoria");
        Iterable<Categoria> categorias = catRepository.findAll();
        mv.addObject("categorias", categorias);
        return mv;
    }

    @RequestMapping(value="/falenciaPessoal/categorias/add", method=RequestMethod.GET)
    public String form(){
        return "addCategoria";
    }

    @PostMapping("/falenciaPessoal/categorias/add")
    public String form(@Validated Categoria categoria, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/falenciaPessoal/categorias/addCategoria";
        }

        catRepository.save(categoria);
        attributes.addFlashAttribute("mensagem", "Categoria cadastrada com sucesso!");
        return "redirect:/falenciaPessoal/categorias";
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

    //------------------ HTML CATEGORIAS





    //------------------ HTML DESPESAS

    @RequestMapping("/falenciaPessoal/despesas")
    public ModelAndView listarDespesa(){
        ModelAndView mv = new ModelAndView("listarDespesas");
        Iterable<Despesa> despesas = despRepository.findAll();
        mv.addObject("despesas", despesas);
        return mv;
    }

    @RequestMapping(value="/falenciaPessoal/despesas/add", method=RequestMethod.GET)
    public String formDespesa(){
        return "addDespesa";
    }

    @PostMapping("/falenciaPessoal/despesas/add")
    public String formDespesa(@Validated Despesa despesa, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/falenciaPessoal/despesas/addDespesa";
        }

        despRepository.save(despesa);
        attributes.addFlashAttribute("mensagem", "Despesa cadastrada com sucesso!");
        return "redirect:/falenciaPessoal/despesas";
    }

    @RequestMapping("/falenciaPessoal/despesas/delete/{id}")
    public String deletarDespesa(@PathVariable("id") Integer codigo){
        despRepository.deleteById(codigo);
        return "redirect:/falenciaPessoal/despesas";
    }

    @RequestMapping(value="/falenciaPessoal/despesas/edit/{id}",method = RequestMethod.GET)
    public ModelAndView detalhesDespesa(@PathVariable("id") Integer codigo){
        ModelAndView mv = null;
        Optional<Despesa> despesa = despRepository.findById(codigo);
        if(despesa.isPresent()){
            mv = new ModelAndView("editDespesa");
            mv.addObject("despesa", despesa.get());
        }

        return mv;
    }

    @RequestMapping("/falenciaPessoal/despesas/edit/{id}")
    public String editarDespesa(@PathVariable("id") Integer id, @Validated Despesa despesa, BindingResult result, Model model){

        Optional<Despesa> existingDespesaOptional = despRepository.findById(id);
        if (existingDespesaOptional.isPresent()) {
            Despesa despesaSalva = existingDespesaOptional.get();
            BeanUtils.copyProperties(despesa, despesaSalva, "id_categoria");
            despRepository.save(despesaSalva);
        }

        return "redirect:/falenciaPessoal/despesas";
    }

    //------------------ HTML DESPESAS








    //------------------ HTML RECEITAS

    @RequestMapping("/falenciaPessoal/receitas")
    public ModelAndView listarReceita(){
        ModelAndView mv = new ModelAndView("listarReceitas");
        Iterable<Receita> receitas = recRepository.findAll();
        mv.addObject("receitas", receitas);
        return mv;
    }

    @RequestMapping(value="/falenciaPessoal/receitas/add", method=RequestMethod.GET)
    public String formReceita(){
        return "addReceita";
    }

    @PostMapping("/falenciaPessoal/receitas/add")
    public String formReceita(@Validated Receita receita, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/falenciaPessoal/receitas/addReceita";
        }

        recRepository.save(receita);
        attributes.addFlashAttribute("mensagem", "Receita cadastrada com sucesso!");
        return "redirect:/falenciaPessoal/receitas";
    }

    @RequestMapping("/falenciaPessoal/receitas/delete/{id}")
    public String deletarReceita(@PathVariable("id") Integer codigo){
        despRepository.deleteById(codigo);
        return "redirect:/falenciaPessoal/receitas";
    }

    @RequestMapping(value="/falenciaPessoal/receitas/edit/{id}",method = RequestMethod.GET)
    public ModelAndView detalhesReceita(@PathVariable("id") Integer codigo){
        ModelAndView mv = null;
        Optional<Receita> receita = recRepository.findById(codigo);
        if(receita.isPresent()){
            mv = new ModelAndView("editReceita");
            mv.addObject("receita", receita.get());
        }
        return mv;
    }

    @RequestMapping("/falenciaPessoal/receitas/edit/{id}")
    public String editarReceita(@PathVariable("id") Integer id, @Validated Receita receita, BindingResult result, Model model){

        Optional<Receita> existingReceitaOptional = recRepository.findById(id);
        if (existingReceitaOptional.isPresent()) {
            Receita receitaSalva = existingReceitaOptional.get();
            BeanUtils.copyProperties(receita, receitaSalva, "id_categoria");
            recRepository.save(receitaSalva);
        }

        return "redirect:/falenciaPessoal/receitas";
    }

    //------------------ HTML RECEITAS


}
