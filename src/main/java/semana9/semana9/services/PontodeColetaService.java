package semana9.semana9.services;

import org.springframework.stereotype.Service;
import semana9.semana9.DTOs.PontodeColetaRequestDto;
import semana9.semana9.DTOs.PontodeColetaResponseDto;
import semana9.semana9.entities.LixoEletronico;
import semana9.semana9.entities.PontodeColeta;
import semana9.semana9.errors.LixoEletronicoNotFoundException;
import semana9.semana9.errors.PontodeColetaNotFoundException;
import semana9.semana9.mappers.PontodeColetaMapper;
import semana9.semana9.repositories.PontodeColetaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PontodeColetaService {


    private final PontodeColetaRepository repository;

    public PontodeColetaService(PontodeColetaRepository repository){
        this.repository = repository;
    }



    public List<PontodeColetaResponseDto> findAll(){
        List <PontodeColeta> pontodeColeta = repository.findAll();
        return PontodeColetaMapper.responseDtos(pontodeColeta);

    }

    public PontodeColetaResponseDto findById(Long id){
        PontodeColeta ponto = repository.findById(id).orElseThrow(() -> new PontodeColetaNotFoundException(id));
            if (ponto != null){
                return PontodeColetaMapper.responseDto(ponto);
            }


        return null ;
    }
    public PontodeColetaResponseDto create(PontodeColetaRequestDto dto){
        return save( new PontodeColeta(), dto);
    }

    public PontodeColetaResponseDto update(Long id, PontodeColetaRequestDto dto){
        PontodeColeta ponto = repository.findById(id).orElseThrow(() -> new PontodeColetaNotFoundException(id));
      return save(ponto, dto);
    }

    public PontodeColetaResponseDto save(PontodeColeta ponto, PontodeColetaRequestDto dto){
        ponto.setNome(dto.nome());
        ponto.setEndereco(dto.endereco());
        ponto.setDiadeColeta(dto.diadeColeta());
        ponto.setMateriaisAceitosnoPonto(dto.materiaisAceitosnoPonto());

        repository.save(ponto);

        return PontodeColetaMapper.responseDto(ponto);
    }

    public void delete (Long id){
        repository.findById(id).orElseThrow(() -> new PontodeColetaNotFoundException(id));
        repository.deleteById(id);

    }



}
