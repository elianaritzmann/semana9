package semana9.semana9.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import semana9.semana9.DTOs.PontodeColetaRequestDto;
import semana9.semana9.DTOs.PontodeColetaResponseDto;
import semana9.semana9.services.PontodeColetaService;

import java.util.List;

@RestController
@RequestMapping("/pontosdecoleta")
public class PontodeColetaController {

    private final PontodeColetaService service;

    public PontodeColetaController(PontodeColetaService service){
        this.service = service;
    }

    @GetMapping
    public List<PontodeColetaResponseDto> getAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public PontodeColetaResponseDto getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/nome{nome}")
    public List<PontodeColetaResponseDto> filtro(@PathVariable String nome){
        return service.findMaterial(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PontodeColetaResponseDto post(@RequestBody PontodeColetaRequestDto dto){
        return service.create(dto);
    }

    @PutMapping("{id}")
    public PontodeColetaResponseDto put(@PathVariable Long id,@RequestBody PontodeColetaRequestDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}


