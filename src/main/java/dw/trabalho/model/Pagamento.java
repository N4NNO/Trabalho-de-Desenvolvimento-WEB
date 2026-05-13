package dw.trabalho.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pagamento",
       uniqueConstraints = @UniqueConstraint(columnNames = {"cod_jogador", "ano", "mes"}))
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_pagamento;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private Integer mes;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "cod_jogador", nullable = false)
    private Jogador jogador;

    public Long getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(Long cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}