package semana9.semana9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semana9.semana9.DTOs.LixoEletronicoRequestDto;
import semana9.semana9.DTOs.LixoEletronicoResponseDto;
import semana9.semana9.entities.LixoEletronico;
import semana9.semana9.errors.LixoEletronicoNotFoundException;
import semana9.semana9.mappers.LixoEletronicoMapper;
import semana9.semana9.repositories.LixoEletronicoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LixoEletronicoService {


    private final LixoEletronicoRepository repository;

    public LixoEletronicoService (LixoEletronicoRepository repository){
        this.repository = repository;
    }



    public List<LixoEletronicoResponseDto> findAll(){
        List <LixoEletronico> lixoEletronico = repository.findAll();
        return LixoEletronicoMapper.responseDtos(lixoEletronico);

    }

    public LixoEletronicoResponseDto findById(Long id){
        LixoEletronico lixo = repository.findById(id).orElseThrow(() -> new LixoEletronicoNotFoundException(id));
            if (lixo != null){
                return LixoEletronicoMapper.responseDto(lixo);

            }


        return null ;
    }
    public LixoEletronicoResponseDto create(LixoEletronicoRequestDto dto){
        return save( new LixoEletronico(), dto);
    }

    public LixoEletronicoResponseDto update(Long id, LixoEletronicoRequestDto dto){
        LixoEletronico lixo = repository.findById(id).orElseThrow(() -> new LixoEletronicoNotFoundException(id));
      return save(lixo, dto);
    }

    public LixoEletronicoResponseDto save(LixoEletronico lixo, LixoEletronicoRequestDto dto){
        lixo.setTipodoLixo(dto.tipodoLixo());
        lixo.setDescricao(dto.descricao());
        repository.save(lixo);

        return LixoEletronicoMapper.responseDto(lixo);

    }

    public void delete (Long id){
        repository.findById(id).orElseThrow(() -> new LixoEletronicoNotFoundException(id));
        repository.deleteById(id);

    }




}
