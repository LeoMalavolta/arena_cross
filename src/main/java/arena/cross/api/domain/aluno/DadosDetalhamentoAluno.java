package arena.cross.api.domain.aluno;

import java.time.LocalDate;

public record DadosDetalhamentoAluno(Long id, String nome, String email, String telefone, LocalDate data_nascimento) {

    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getData_nascimento());

    }
}
