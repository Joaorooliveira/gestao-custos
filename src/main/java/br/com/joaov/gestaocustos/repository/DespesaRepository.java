package br.com.joaov.gestaocustos.repository;

import br.com.joaov.gestaocustos.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {


}
