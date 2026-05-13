package dw.trabalho.repository;

import dw.trabalho.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByJogadorCodJogador(Integer codJogador);
    boolean existsByJogadorCodJogadorAndAnoAndMes(Integer codJogador, Integer ano, Integer mes);
}