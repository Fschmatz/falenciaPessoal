package com.fschmatz.falenciaPessoal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fschmatz.falenciaPessoal.entity.Categoria;
import com.fschmatz.falenciaPessoal.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import javax.transaction.Transactional;

@RestController
//@Controller  //video disse para usar controller ??
@AllArgsConstructor
@Transactional
@RequestMapping("/categoria")
public class CategoriaController {

    CategoriaRepository repository;


    //--->  TESTES
    /* @RequestMapping(value="index")
    public static String getAllCategorias(){
        return "index";
    }

   @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        try {
            List<Categoria> items = new ArrayList<Categoria>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


    //--->  TESTES


    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        try {
            List<Categoria> items = new ArrayList<Categoria>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> getById(@PathVariable("id") Integer id) {
        Optional<Categoria> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        try {
            Categoria savedItem = repository.save(categoria);
            System.out.println(savedItem.toString());
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> update(@PathVariable("id") Integer id, @RequestBody Categoria categoria) {
        Optional<Categoria> existingCategoriaOptional = repository.findById(id);
        if (existingCategoriaOptional.isPresent()) {
            Categoria categoriaSalva = existingCategoriaOptional.get();
            BeanUtils.copyProperties(categoria, categoriaSalva, "id_categoria");
            return new ResponseEntity<>(repository.save(categoriaSalva), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}