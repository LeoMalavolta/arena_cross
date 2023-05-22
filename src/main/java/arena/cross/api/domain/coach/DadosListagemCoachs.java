package arena.cross.api.domain.coach;

import java.time.LocalDate;

public record DadosListagemCoachs(Long id,String nome, String cref, String email, String telefone, LocalDate data_nascimento) {

    public DadosListagemCoachs(Coach coach){
        this(coach.getId(), coach.getNome(), coach.getCref(), coach.getEmail(), coach.getTelefone(), coach.getData_nascimento());
    }
}
