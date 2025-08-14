// Local: src/main/java/br/com/timecerto/api/atletas/AtletaRepository.java
package br.com.timecerto.Api.atletas;

import org.springframework.data.jpa.repository.JpaRepository;

// A interface estende JpaRepository<TipoDaEntidade, TipoDoId>
public interface AtletaRepository extends JpaRepository<Atleta, Integer> {
    // O Spring Data JPA implementará todos os métodos CRUD basicos automaticamente!
}