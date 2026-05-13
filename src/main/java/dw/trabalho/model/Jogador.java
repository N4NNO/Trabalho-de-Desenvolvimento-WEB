package dw.trabalho.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_jogador")
    private Integer codJogador;

    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 60)
    private String email;

    private LocalDate datanasc;

    @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pagamento> pagamentos;

    public Jogador() {}

    public Integer getCodJogador() { return codJogador; }
    public void setCodJogador(Integer codJogador) { this.codJogador = codJogador; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDatanasc() { return datanasc; }
    public void setDatanasc(LocalDate datanasc) { this.datanasc = datanasc; }

    public List<Pagamento> getPagamentos() { return pagamentos; }
    public void setPagamentos(List<Pagamento> pagamentos) { this.pagamentos = pagamentos; }
}