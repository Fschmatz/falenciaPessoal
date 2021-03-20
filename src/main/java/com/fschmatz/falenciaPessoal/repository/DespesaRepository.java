package com.fschmatz.falenciaPessoal.repository;

import com.fschmatz.falenciaPessoal.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DespesaRepository extends JpaRepository<Despesa, Integer> {
}
