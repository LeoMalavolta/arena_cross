package arena.cross.api.domain.aluno;

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
@Table(name = "alunos")
@Entity(name = "Aluno")
public class Aluno {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate data_nascimento;

    private Boolean ativo;

    public Aluno(DadosCadastroAluno dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.data_nascimento = dados.data_nascimento();

    }

    public void atualizarInformacoes(DadosAtualizarAluno dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }

        if(dados.email() != null) {
            this.email = dados.email();
        }

        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    public void excluir() {this.ativo = false;}
}

