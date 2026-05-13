package dw.trabalho.controller;

import dw.trabalho.model.Jogador;
import dw.trabalho.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {
    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public List<Jogador> listar() {
        return jogadorService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Jogador> criar(@RequestBody Jogador jogador) {
        Jogador novo = jogadorService.criar(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public Jogador buscar(@PathVariable Integer id) {
        return jogadorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Jogador atualizar(@PathVariable Integer id, @RequestBody Jogador jogador) {
        return jogadorService.atualizar(id, jogador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        jogadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}