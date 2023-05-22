package arena.cross.api.controller;

import arena.cross.api.domain.coach.*;
import arena.cross.api.domain.coach.Coach;
import arena.cross.api.domain.coach.CoachRepository;
import arena.cross.api.domain.coach.DadosListagemCoachs;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/coachs")
public class CoachController {

    @Autowired
    private CoachRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCoach dados, UriComponentsBuilder uriComponentsBuilder) {
        var coach = new Coach(dados);
        repository.save(new Coach(dados));

        var uri = uriComponentsBuilder.path("/coachs/{id}").buildAndExpand(coach.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCoach(coach));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCoachs>> listar(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemCoachs::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarCoach dados) {
        var coach = repository.getReferenceById(dados.id());
        coach.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCoach(coach));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var coach = repository.getReferenceById(id);
        coach.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var coach = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoCoach(coach));
    }
}
