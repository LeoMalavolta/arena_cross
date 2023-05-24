package arena.cross.api.controller;

import arena.cross.api.domain.aluno.*;
import arena.cross.api.domain.aluno.DadosListagemAlunos;
import arena.cross.api.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("alunos")
public class AlunosController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriComponentsBuilder) {
        return alunoService.cadastrarAluno(dados, uriComponentsBuilder);
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemAlunos>> listar(Pageable paginacao) {
        return alunoService.listarAluno(paginacao);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarAluno dados) {
        return alunoService.atualizarAluno(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        return alunoService.excluirAluno(id);
    }

    @GetMapping ("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        return alunoService.detalharAluno(id);
    }
}
