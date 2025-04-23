package semana9.semana9.DTOs;

import semana9.semana9.entities.Material;

import java.time.LocalDate;
import java.util.List;

public record PontodeColetaRequestDto(

        String nome,
        String endereco,
        LocalDate diadeColeta,
        List<Material> materiaisAceitosnoPonto
) {
}
