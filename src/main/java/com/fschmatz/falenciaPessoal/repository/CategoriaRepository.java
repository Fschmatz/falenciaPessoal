package com.fschmatz.falenciaPessoal.repository;

import com.fschmatz.falenciaPessoal.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    public Page<Categoria> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);

}
