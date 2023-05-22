package arena.cross.api.domain.coach;

import arena.cross.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DadosCadastroCoach(
        @NotBlank
        String nome,
        @Pattern(regexp = "\\d{6}")
        String cref,
        @Email
        @NotBlank
        String email,
        @Pattern(regexp = "\\d{10,13}")
        @NotNull
        String telefone,
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        @NotNull
        LocalDate data_nascimento,
        @Valid
        @NotNull
        DadosEndereco endereco) {
}
