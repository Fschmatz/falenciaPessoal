package com.fschmatz.falenciaPessoal.repository;

import com.fschmatz.falenciaPessoal.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Optional<Usuario> findByLogin(String login);
}
