package com.fschmatz.falenciaPessoal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perfil implements GrantedAuthority{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_perfil;
    
    @Column(name="nome_perfil")
    private String nomePerfil;

    @Override
    public String getAuthority() {
        return nomePerfil;
    }
    
}
