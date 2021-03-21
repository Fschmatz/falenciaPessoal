package com.fschmatz.falenciaPessoal.controller;


import com.fschmatz.falenciaPessoal.entity.Receita;
import com.fschmatz.falenciaPessoal.repository.ReceitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Transactional
@RequestMapping("/receita")
public class ReceitaController {

    ReceitaRepository repository;


    @GetMapping
    public ResponseEntity<List<Receita>> getAll() {
        try {
            List<Receita> items = new ArrayList<Receita>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Receita> getById(@PathVariable("id") Integer id) {
        Optional<Receita> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Receita> create(@RequestBody Receita Receita) {
        try {
            Receita savedItem = repository.save(Receita);
            System.out.println(savedItem.toString());
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Receita> update(@PathVariable("id") Integer id, @RequestBody Receita Receita) {
        Optional<Receita> existingReceitaOptional = repository.findById(id);
        if (existingReceitaOptional.isPresent()) {
            Receita ReceitaSalva = existingReceitaOptional.get();
            BeanUtils.copyProperties(Receita, ReceitaSalva, "id_Receita");
            return new ResponseEntity<>(repository.save(ReceitaSalva), HttpStatus.OK);
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