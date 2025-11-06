package br.com.joaov.gestaocustos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
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

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(length = 100,nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String email;

    @CreationTimestamp
    private LocalDate data_criacao;



}
