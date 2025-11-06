package br.com.joaov.gestaocustos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="despesa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    private String descricao;
    private LocalDate data;
    private BigDecimal valor;
    @Column(length = 100)
    private String categoria;
    private String email;

    @CreatedDate
    private LocalDate data_criacao;



}
