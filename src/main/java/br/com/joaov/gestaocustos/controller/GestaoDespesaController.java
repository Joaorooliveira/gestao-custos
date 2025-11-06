package br.com.joaov.gestaocustos.controller;

import br.com.joaov.gestaocustos.custom_messages.ErrorMessage;
import br.com.joaov.gestaocustos.entity.Despesa;
import br.com.joaov.gestaocustos.useCases.CadastroDespesasUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

    @Autowired
    private CadastroDespesasUseCase cadastroDespesasUseCase;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Despesa despesa){
        try{
            var result = cadastroDespesasUseCase.execute(despesa);
            return ResponseEntity.ok().body(result);
        }catch (IllegalArgumentException e){
            var errorMessage= new ErrorMessage(e.getMessage(),"INVALIDD_PARAMS");
            return ResponseEntity.status(400).body(errorMessage);
        }
    }


}
