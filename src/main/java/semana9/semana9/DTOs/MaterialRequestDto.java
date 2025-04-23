package semana9.semana9.DTOs;

import semana9.semana9.entities.LixoEletronico;
import semana9.semana9.entities.PontodeColeta;

public record MaterialRequestDto(
        PontodeColeta pontodeColeta,
        LixoEletronico lixoEletronico,
        double capacidadeMaxima
) {
}
