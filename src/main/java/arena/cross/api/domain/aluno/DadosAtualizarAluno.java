package arena.cross.api.domain.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAluno(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone) {
}
