package br.com.joaov.gestaocustos.useCases;
import br.com.joaov.gestaocustos.entity.Despesa;
import br.com.joaov.gestaocustos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDespesasUseCase {


    private final DespesaRepository despesaRepository;

    public CadastroDespesasUseCase(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public Despesa execute(Despesa despesa){
        if(despesa.getCategoria() == null || despesa.getData() == null || despesa.getDescricao() == null||
                despesa.getEmail() == null){
            throw new IllegalArgumentException("Preencher todos os campos");
        }

        return despesaRepository.saveAndFlush(despesa);

    }
}
