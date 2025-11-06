package br.com.joaov.gestaocustos.performance;

import br.com.joaov.gestaocustos.entity.Despesa;
import br.com.joaov.gestaocustos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/gestao/performance")
@RestController
@EnableCaching
public class GestaoDespesaPerformance {

    @Autowired
    DespesaRepository despesaRepository;

    @GetMapping("/sem-paginacao")
    public ResponseEntity<List<Despesa>> listarSemPaginacao() {
        long inicio = System.currentTimeMillis();
        var despesas = despesaRepository.findAll();
        long fim = System.currentTimeMillis();
        System.out.println("Tempo (sem paginacao): "+(fim-inicio)+"ms");
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/com-paginacao")
    public ResponseEntity<Page<Despesa>> listarComPaginacao(Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var despesas = despesaRepository.findAll(pageable);
        stopWatch.stop();
        System.out.println("Tempo (com paginacao): "+stopWatch.getTotalTimeMillis()+"ms");
        return ResponseEntity.ok(despesas);
    }
    @GetMapping("/com-paginacao/{email}")
    public ResponseEntity<Page<Despesa>> listarComPaginacao(@PathVariable String email, Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var despesas = despesaRepository.findByEmail(email,pageable);
        stopWatch.stop();
        return ResponseEntity.ok(despesas);
    }
    @Cacheable(value="gastosPorEmailCache", key ="#email + '-'+ #pageable.pageNumber+'-'+#pageable.pageSize+'-'")
    @GetMapping("/cache{email}")
    public ResponseEntity<Page<Despesa>> cacheComPaginacao(@PathVariable String email, Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var despesas = despesaRepository.findByEmail(email,pageable);
        stopWatch.stop();
        return ResponseEntity.ok(despesas);
    }
}
