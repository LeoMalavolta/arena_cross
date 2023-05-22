package arena.cross.api.service;

import arena.cross.api.domain.aluno.Aluno;
import arena.cross.api.domain.aluno.AlunoRepository;
import arena.cross.api.domain.aluno.DadosCadastroAluno;
import arena.cross.api.domain.aluno.DadosDetalhamentoAluno;
import org.springframework.beans.factory.annotation.Autowired;
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
}
