// Local: src/main/java/br/com/timecerto/api/atletas/AtletaController.java
package br.com.timecerto.api.atletas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controller REST para gerenciar as operações da entidade Atleta.
 * Expõe os endpoints da API relacionados a atletas.
 */
@RestController
@RequestMapping("/api/atletas")
public class AtletaController {

    // Injeção de dependência do repositório para acesso aos dados
    @Autowired
    private AtletaRepository repository;

    /**
     * Endpoint para LISTAR todos os atletas cadastrados.
     * Mapeado para: GET /api/atletas
     */
    @GetMapping
    public List<Atleta> listarTodos() {
        return repository.findAll();
    }

    /**
     * Endpoint para DETALHAR os dados de um único atleta pelo seu ID.
     * Mapeado para: GET /api/atletas/{id}
     * @return Os dados do atleta (200 OK) ou 404 Not Found se não existir.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Atleta> detalhar(@PathVariable Long id) {
        var atleta = repository.findById(id.intValue());
        if (atleta.isPresent()) {
            return ResponseEntity.ok(atleta.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Endpoint para CADASTRAR um novo atleta.
     * Mapeado para: POST /api/atletas
     */
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroAtleta dados) {
        Atleta novoAtleta = new Atleta();
        novoAtleta.setNome(dados.nome());
        novoAtleta.setPosicao(dados.posicao());
        novoAtleta.setNivel(dados.nivel());
        novoAtleta.setTelefone(dados.telefone());
        repository.save(novoAtleta);
    }

    /**
     * Endpoint para ATUALIZAR os dados de um atleta existente.
     * Mapeado para: PUT /api/atletas
     */
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoAtleta dados) {
        // Carrega a entidade do banco para garantir que ela está sendo gerenciada pelo JPA
        Atleta atleta = repository.getReferenceById(dados.id().intValue());
        
        // Atualiza os campos da entidade com os novos dados, se eles foram fornecidos
        if (dados.nome() != null) atleta.setNome(dados.nome());
        if (dados.posicao() != null) atleta.setPosicao(dados.posicao());
        if (dados.nivel() != null) atleta.setNivel(dados.nivel());
        if (dados.telefone() != null) atleta.setTelefone(dados.telefone());
        // A anotação @Transactional se encarrega de salvar as alterações no banco.
    }

    /**
     * Endpoint para DELETAR um atleta existente pelo seu ID.
     * Mapeado para: DELETE /api/atletas/{id}
     */
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id.intValue());
    }
}