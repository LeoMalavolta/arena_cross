package arena.cross.api.domain.aluno;

import java.time.LocalDate;

public record DadosListagemAlunos(Long Id, String nome, String email, String telefone, LocalDate data_nascimento) {

    public DadosListagemAlunos(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getData_nascimento());
    }
}
