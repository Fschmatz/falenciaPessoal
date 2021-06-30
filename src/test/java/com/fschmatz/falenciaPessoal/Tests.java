package com.fschmatz.falenciaPessoal;

import com.fschmatz.falenciaPessoal.controller.CategoriaController;
import com.fschmatz.falenciaPessoal.controller.DespesaController;
import com.fschmatz.falenciaPessoal.controller.ReceitaController;
import com.fschmatz.falenciaPessoal.controller.UsuarioController;
import com.fschmatz.falenciaPessoal.entity.Categoria;
import com.fschmatz.falenciaPessoal.entity.Despesa;
import com.fschmatz.falenciaPessoal.entity.Receita;
import com.fschmatz.falenciaPessoal.entity.Usuario;
import com.fschmatz.falenciaPessoal.repository.CategoriaRepository;
import com.fschmatz.falenciaPessoal.repository.DespesaRepository;
import com.fschmatz.falenciaPessoal.repository.ReceitaRepository;
import com.fschmatz.falenciaPessoal.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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

    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    UsuarioRepository usuarioRepository;



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
    public void getCategoriaContagemTest() throws Exception {
        List<Categoria> existingItemOptional = catRepository.findAll();
        assertThat(existingItemOptional.size()).isGreaterThan(0);
    }

    @Test
    public void getCategoriaByIdTest() throws Exception {
        assertThat(catController.getById(1)).isNotNull();
    }

    @Test
    public void getCategoriaNameByIdTest() throws Exception {
        Optional<Categoria> existingItemOptional = catRepository.findById(1);
        assertThat(existingItemOptional.get().getDescricao()).isNotEqualTo("Bumerangues");
    }

    // qual o pq desse erro?
    @Test
    public void getCategoriaNameByIdOtherTest() throws Exception {
        Optional<Categoria> existingItemOptional = catRepository.findById(1);
        assertThat(existingItemOptional.get().getDescricao()).isNotNull();
    }



//--------------------- DESPESA

    @Test
    public void contextLoadsDespesaTest() throws Exception {
        assertThat(despesaController).isNotNull();
    }

    @Test
    public void getAllDespesaTest() throws Exception {
        assertThat(despesaController.getAll()).isNotNull();
    }

    @Test
    public void getDespesaContagemTest() throws Exception {
        List<Despesa> existingItemOptional = despesaRepository.findAll();
        assertThat(existingItemOptional.size()).isGreaterThan(0);
    }

    @Test
    public void getDespesaNameVazioTest() throws Exception {
        Optional<Despesa> existingItemOptional = despesaRepository.findById(2);
        assertThat(existingItemOptional.get().getNome()).isNotNull();
    }

    @Test
    public void getDespesaByIdTest() throws Exception {
        assertThat(despesaController.getById(1)).isNotNull();
    }

    @Test
    public void getDespesaNameByIdTest() throws Exception {
        Optional<Despesa> existingItemOptional = despesaRepository.findById(2);
        Assert.assertTrue(existingItemOptional.get().getCategoria().getDescricao() != null);
    }

    @Test
    public void getDespesaCategTest() throws Exception {
        Optional<Despesa> existingItemOptional = despesaRepository.findById(2);
        assertThat(existingItemOptional.get().getCategoria()).isNotNull();
    }




//--------------------- RECEITA

    @Test
    public void contextLoadsReceitaTest() throws Exception {
        assertThat(receitaController).isNotNull();
    }

    @Test
    public void getAllReceitaTest() throws Exception {
        assertThat(receitaController.getAll()).isNotNull();
    }


    @Test
    public void getReceitaByIdTest() throws Exception {
        assertThat(receitaController.getById(1)).isNotNull();
    }

    @Test
    public void getReceitaContagemTest() throws Exception {
        List<Receita> existingItemOptional = receitaRepository.findAll();
        assertThat(existingItemOptional.size()).isGreaterThan(0);
    }

    @Test
    public void getReceitaByIdBoolTest() throws Exception {
        Assert.assertTrue(receitaRepository.findById(2) != null);
    }

    @Test
    public void getReceitaNameVazioTest() throws Exception {
        Optional<Receita> existingItemOptional = receitaRepository.findById(1);
        assertThat(existingItemOptional.get().getNome()).isNotNull();
    }

    @Test
    public void getReceitaNameTest() throws Exception {
        Optional<Receita> existingItemOptional = receitaRepository.findById(1);
        assertThat(existingItemOptional.get().getNome()).isNotEqualTo("Despesa");
    }

    @Test
    public void getReceitaNameByIdTest() throws Exception {
        Optional<Receita> existingItemOptional = receitaRepository.findById(2);
        Assert.assertTrue(existingItemOptional.get().getCategoria().getDescricao() != null);
    }

    @Test
    public void getReceitaCategTest() throws Exception {
        Optional<Receita> existingItemOptional = receitaRepository.findById(1);
        assertThat(existingItemOptional.get().getCategoria()).isNotNull();
    }




//--------------------- USUARIO

    @Test
    public void contextLoadsUsarioTest() throws Exception {
        assertThat(usuarioController).isNotNull();
    }

    @Test
    public void getAllUsuarioTest() throws Exception {
        assertThat(usuarioController.getAll()).isNotNull();
    }

    @Test
    public void getUsuarioContagemTest() throws Exception {
        List<Usuario> existingItemOptional = usuarioRepository.findAll();
        assertThat(existingItemOptional.size()).isGreaterThan(0);
    }

    @Test
    public void getUsuarioByIdTest() throws Exception {
        assertThat(usuarioController.getById(1)).isNotNull();
    }

    @Test
    public void getUsuarioNameAdminTest() throws Exception {
        Optional<Usuario> existingItemOptional = usuarioRepository.findById(1);
        assertThat(existingItemOptional.get().getNome()).isEqualTo("admin");
    }

    @Test
    public void getUsuarioPerfilAdminTest() throws Exception {
        Optional<Usuario> existingItemOptional = usuarioRepository.findById(1);
        assertThat(existingItemOptional.get().getPerfil()).isNotNull();
    }

    @Test
    public void getUsuarioUsernameAdminTest() throws Exception {
        Optional<Usuario> existingItemOptional = usuarioRepository.findById(1);
        assertThat(existingItemOptional.get().getUsername()).isNotNull();
    }

    @Test
    public void getUsuarioSenhaAdminTest() throws Exception {
        Optional<Usuario> existingItemOptional = usuarioRepository.findById(1);
        assertThat(existingItemOptional.get().getPassword()).isNotNull();
    }
}

// LIQUIDBASE INSERE 1 usuário ( o admin ), 4 categorias, 2 receitas e 2 despesas.