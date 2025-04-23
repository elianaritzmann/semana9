package semana9.semana9.mappers;

import semana9.semana9.DTOs.PontodeColetaResponseDto;
import semana9.semana9.entities.PontodeColeta;

import java.util.List;

public class PontodeColetaMapper {

    private PontodeColetaMapper(){}

    public static PontodeColetaResponseDto responseDto (PontodeColeta ponto){
        return new PontodeColetaResponseDto(
                ponto.getId(),
                ponto.getNome(),
                ponto.getEndereco(),
                ponto.getDiadeColeta(),
                ponto.getMateriaisAceitosnoPonto()

        );


    }

    public static List <PontodeColetaResponseDto> responseDtos (List<PontodeColeta>pontos){
       return pontos.stream().map(PontodeColetaMapper::responseDto).toList();
}}

