package semana9.semana9.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import semana9.semana9.DTOs.LixoEletronicoRequestDto;
import semana9.semana9.DTOs.LixoEletronicoResponseDto;
import semana9.semana9.repositories.LixoEletronicoRepository;
import semana9.semana9.services.LixoEletronicoService;

import java.util.List;

@RestController
@RequestMapping("/lixoseletronicos")
public class LixoEletronicoController {

    private final LixoEletronicoService service;

    public LixoEletronicoController (LixoEletronicoService service){
        this.service = service;
    }

    @GetMapping
    public List<LixoEletronicoResponseDto> getAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public LixoEletronicoResponseDto getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LixoEletronicoResponseDto post(@RequestBody LixoEletronicoRequestDto dto){
        return service.create(dto);
    }

    @PutMapping("{id}")
    public LixoEletronicoResponseDto put(@PathVariable Long id,@RequestBody LixoEletronicoRequestDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}


