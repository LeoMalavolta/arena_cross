package arena.cross.api.domain.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DadosCadastroAluno(
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email,
        @Pattern(regexp = "\\d{10,13}")
        @NotNull
        String telefone,
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        @NotNull
        LocalDate data_nascimento) {
}
