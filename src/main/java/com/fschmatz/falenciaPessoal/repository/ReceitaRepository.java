package com.fschmatz.falenciaPessoal.repository;

import com.fschmatz.falenciaPessoal.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}
