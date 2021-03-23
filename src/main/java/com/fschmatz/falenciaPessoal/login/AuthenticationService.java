package com.fschmatz.falenciaPessoal.login;

import com.fschmatz.falenciaPessoal.entity.Usuario;
import com.fschmatz.falenciaPessoal.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<Usuario> usuario = repository.findByLogin(login);
        if (usuario == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return usuario.get();
    }

}
