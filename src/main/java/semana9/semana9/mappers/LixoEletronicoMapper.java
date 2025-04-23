package semana9.semana9.mappers;

import semana9.semana9.DTOs.LixoEletronicoResponseDto;
import semana9.semana9.entities.LixoEletronico;

import java.util.List;

public class LixoEletronicoMapper {

    private LixoEletronicoMapper(){}

    public static LixoEletronicoResponseDto responseDto (LixoEletronico entidade){
        return new LixoEletronicoResponseDto(
                entidade.getId(),
                entidade.getTipodoLixo(),
                entidade.getDescricao()
        );


    }

    public static List <LixoEletronicoResponseDto> responseDtos (List<LixoEletronico>entidades){
       return entidades.stream().map(LixoEletronicoMapper::responseDto).toList();
}}

