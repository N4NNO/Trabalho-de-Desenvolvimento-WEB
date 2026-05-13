package dw.trabalho.repository;

import dw.trabalho.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
    boolean existsByEmail(String email);
}