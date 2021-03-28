package com.fschmatz.falenciaPessoal.repository;

import com.fschmatz.falenciaPessoal.entity.Despesa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

    //public Page<Despesa> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);

}
