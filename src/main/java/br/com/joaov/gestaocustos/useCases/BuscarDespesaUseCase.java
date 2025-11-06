package br.com.joaov.gestaocustos.useCases;

import br.com.joaov.gestaocustos.entity.Despesa;
import br.com.joaov.gestaocustos.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarDespesaUseCase {

    private final DespesaRepository despesaRepository;

    public BuscarDespesaUseCase(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public List<Despesa> execute(String email, LocalDate data){
        List<Despesa> despesas;
        if(data!=null){
            despesas = despesaRepository.findByEmailAndData(email, data);
        }else{
            despesas = despesaRepository.findByEmail(email);
        }
        return despesas;
    }
}
