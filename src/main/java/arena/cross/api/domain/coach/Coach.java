package arena.cross.api.domain.coach;

import arena.cross.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
@Table(name = "coachs")
@Entity(name = "coach")
public class Coach {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cref;
    private String email;
    private String telefone;
    private LocalDate data_nascimento;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Coach(DadosCadastroCoach dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.cref = dados.cref();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.data_nascimento = dados.data_nascimento();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarCoach dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.email() != null) {
            this.email = dados.email();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
