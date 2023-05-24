package arena.cross.api.service;

import arena.cross.api.domain.aluno.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public ResponseEntity cadastrarAluno(DadosCadastroAluno dados, UriComponentsBuilder uriComponentsBuilder) {
        var aluno = new Aluno(dados);
        repository.save(new Aluno(dados));

        var uri = uriComponentsBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
    }

    public ResponseEntity listarAluno(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAlunos::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity atualizarAluno(DadosAtualizarAluno dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    public ResponseEntity excluirAluno(Long id) {
        var aluno = repository.getReferenceById(id);
        aluno.excluir();
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity detalharAluno(Long id) {
        var aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }
}
