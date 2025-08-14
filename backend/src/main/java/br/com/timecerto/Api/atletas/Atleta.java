// Local: src/main/java/br/com/timecerto/api/atletas/Atleta.java
package br.com.timecerto.Api.atletas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // Anotação que indica que esta classe é uma entidade JPA
@Table(name = "atletas") // Mapeia para a tabela "atletas" no banco
@Data // Lombok: gera getters, setters, toString, equals e hashCode
@NoArgsConstructor // Lombok: gera um construtor sem argumentos
@AllArgsConstructor // Lombok: gera um construtor com todos os argumentos
public class Atleta {

    @Id // Indica que este campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usa a estratégia de auto-incremento do banco (SERIAL)
    private Integer id; // Usamos Integer para mapear o tipo SERIAL do PostgreSQL

    private String nome;
    private String posicao;
    private Integer nivel;
    private String telefone;
    // Se você adicionou mais colunas, declare os campos aqui também
}
