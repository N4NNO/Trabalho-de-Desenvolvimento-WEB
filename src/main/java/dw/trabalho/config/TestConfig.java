package dw.trabalho.config;

import dw.trabalho.model.Jogador;
import dw.trabalho.model.Pagamento;
import dw.trabalho.repository.JogadorRepository;
import dw.trabalho.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (jogadorRepository.count() == 0) {
            Jogador j1 = new Jogador();
            j1.setNome("Ronaldo Fenômeno");
            j1.setEmail("ronaldo@futebol.com");
            j1.setDatanasc(LocalDate.of(1976, 9, 18));

            Jogador j2 = new Jogador();
            j2.setNome("Ronaldinho Gaúcho");
            j2.setEmail("bruxo@futebol.com");
            j2.setDatanasc(LocalDate.of(1980, 3, 21));

            jogadorRepository.saveAll(Arrays.asList(j1, j2));

            Pagamento p1 = new Pagamento();
            p1.setAno(2026);
            p1.setMes(4);
            p1.setValor(new BigDecimal("150.50"));
            p1.setJogador(j1);

            Pagamento p2 = new Pagamento();
            p2.setAno(2026);
            p2.setMes(5);
            p2.setValor(new BigDecimal("150.50"));
            p2.setJogador(j1);

            Pagamento p3 = new Pagamento();
            p3.setAno(2026);
            p3.setMes(5);
            p3.setValor(new BigDecimal("200.00"));
            p3.setJogador(j2);

            pagamentoRepository.saveAll(Arrays.asList(p1, p2, p3));
        }
    }
}