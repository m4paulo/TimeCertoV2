// Local: src/main/java/br/com/timecerto/api/atletas/DadosAtualizacaoAtleta.java
package br.com.timecerto.api.atletas;

// Este DTO inclui o ID, pois ele é essencial para a operação de atualização.
// Os outros campos são os que permitiremos que sejam alterados pela API.
public record DadosAtualizacaoAtleta(
    Long id, // Usamos Long para o ID por ser mais robusto
    String nome,
    String posicao,
    Integer nivel,
    String telefone
) {
}