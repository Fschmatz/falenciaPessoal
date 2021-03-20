package com.fschmatz.falenciaPessoal.repository;

import com.fschmatz.falenciaPessoal.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
