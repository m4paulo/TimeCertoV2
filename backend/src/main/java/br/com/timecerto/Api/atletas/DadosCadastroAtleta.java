// Local: src/main/java/br/com/timecerto/api/atletas/DadosCadastroAtleta.java
package br.com.timecerto.api.atletas;

// Este record serve como um "molde" para os dados que chegam na requisição POST.
// Apenas os campos que você espera receber do frontend são listados aqui.
public record DadosCadastroAtleta(
    String nome,
    String posicao,
    Integer nivel,
    String telefone
) {
}