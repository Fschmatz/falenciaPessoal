package com.fschmatz.falenciaPessoal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_despesa;

    private String nome;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

}
