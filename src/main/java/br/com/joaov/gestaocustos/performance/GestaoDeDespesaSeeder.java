package br.com.joaov.gestaocustos.performance;

import br.com.joaov.gestaocustos.entity.Despesa;
import br.com.joaov.gestaocustos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class GestaoDeDespesaSeeder implements CommandLineRunner {

    @Autowired
    DespesaRepository despesaRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Despesa> despesas = new ArrayList<>();
        System.out.println("Iniciando geracao de seed");
        for (int i = 1; i <= 150000; i++) {
            Despesa despesa = new Despesa();
            despesa.setDescricao("Gasto n: " + i);
            despesa.setValor(BigDecimal.valueOf(10+(i%50)));
            despesa.setData(LocalDate.now().minusDays(i%30)); // 1- 30
            despesa.setCategoria("TESTE");
            despesa.setEmail("performance@gmail.com");

            despesas.add(despesa);
        }
        despesaRepository.saveAll(despesas);
        System.out.println("Finalizou geracao de seed");
    }
}
