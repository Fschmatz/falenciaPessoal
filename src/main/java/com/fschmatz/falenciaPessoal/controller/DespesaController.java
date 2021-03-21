package com.fschmatz.falenciaPessoal.controller;



import com.fschmatz.falenciaPessoal.entity.Despesa;
import com.fschmatz.falenciaPessoal.repository.DespesaRepository;
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
@RequestMapping("/despesa")
public class DespesaController {

    DespesaRepository repository;

    @GetMapping
    public ResponseEntity<List<Despesa>> getAll() {
        try {
            List<Despesa> items = new ArrayList<Despesa>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Despesa> getById(@PathVariable("id") Integer id) {
        Optional<Despesa> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody Despesa Despesa) {
        try {
            Despesa savedItem = repository.save(Despesa);
            System.out.println(savedItem.toString());
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Despesa> update(@PathVariable("id") Integer id, @RequestBody Despesa Despesa) {
        Optional<Despesa> existingDespesaOptional = repository.findById(id);
        if (existingDespesaOptional.isPresent()) {
            Despesa DespesaSalva = existingDespesaOptional.get();
            BeanUtils.copyProperties(Despesa, DespesaSalva, "id_Despesa");
            return new ResponseEntity<>(repository.save(DespesaSalva), HttpStatus.OK);
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