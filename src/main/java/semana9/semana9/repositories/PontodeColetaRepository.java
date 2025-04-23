package semana9.semana9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import semana9.semana9.DTOs.PontodeColetaResponseDto;
import semana9.semana9.entities.PontodeColeta;

import java.util.List;

public interface PontodeColetaRepository extends JpaRepository<PontodeColeta, Long> {
    List<PontodeColetaResponseDto> findByMateriaisAceitosnoPontoContainingIgnoreCase(String nome );
}
