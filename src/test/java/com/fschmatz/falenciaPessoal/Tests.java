package com.fschmatz.falenciaPessoal;

import com.fschmatz.falenciaPessoal.controller.CategoriaController;
import com.fschmatz.falenciaPessoal.controller.DespesaController;
import com.fschmatz.falenciaPessoal.controller.ReceitaController;
import com.fschmatz.falenciaPessoal.entity.Categoria;
import com.fschmatz.falenciaPessoal.entity.Despesa;
import com.fschmatz.falenciaPessoal.entity.Receita;
import com.fschmatz.falenciaPessoal.repository.CategoriaRepository;
import com.fschmatz.falenciaPessoal.repository.DespesaRepository;
import com.fschmatz.falenciaPessoal.repository.ReceitaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Tests {

    @Autowired
    private CategoriaController catController;

    @Autowired
    CategoriaRepository catRepository;

    @Autowired
    private DespesaController despesaController;

    @Autowired
    DespesaRepository despesaRepository;

    @Autowired
    private ReceitaController receitaController;

    @Autowired
    ReceitaRepository receitaRepository;


//--------------------- CATEGORIA

    @Test
    public void contextLoadsCategoriaTest() throws Exception {
        assertThat(catController).isNotNull();
    }

    @Test
    public void getAllCategoriaTest() throws Exception {
        assertThat(catController.getAll()).isNotNull();
    }

    @Test
    public void getCategoriaByIdTest() throws Exception {
        assertThat(catController.getById(1)).isNotNull();
    }

    @Test
    public void getCategoriaNameByIdTest() throws Exception {
        Optional<Categoria> existingItemOptional = catRepository.findById(1);
        assertThat(existingItemOptional.get().getDescricao()).isEqualTo("Alimentação");
    }

//--------------------- CATEGORIA



//--------------------- DESPESA

    @Test
    public void getAllDespesaTest() throws Exception {
        assertThat(despesaController.getAll()).isNotNull();
    }

    @Test
    public void getDespesaByIdTest() throws Exception {
        assertThat(despesaController.getById(1)).isNotNull();
    }

//--------------------- DESPESA



//--------------------- RECEITA

    @Test
    public void getReceitaByIdTest() throws Exception {
        Assert.assertTrue(receitaRepository.findById(2) != null);
    }

    @Test
    public void getReceitaNameByIdTest() throws Exception {
        Optional<Receita> existingItemOptional = receitaRepository.findById(2);
        Assert.assertTrue(existingItemOptional.get().getCategoria().getDescricao() != null);
    }

//--------------------- RECEITA

}
