package arena.cross.api.domain.coach;

import arena.cross.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizarCoach(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        DadosEndereco endereco) {
}
