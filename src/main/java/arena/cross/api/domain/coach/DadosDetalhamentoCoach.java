package arena.cross.api.domain.coach;

import arena.cross.api.domain.endereco.Endereco;

import java.time.LocalDate;

public record DadosDetalhamentoCoach(Long id, String nome, String cref, String email, String telefone, LocalDate data_nascimento, Endereco endereco) {

    public DadosDetalhamentoCoach(Coach coach){
        this(coach.getId(), coach.getNome(), coach.getCref(), coach.getEmail(), coach.getTelefone(), coach.getData_nascimento(), coach.getEndereco());
    }
}
