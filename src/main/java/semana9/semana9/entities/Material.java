package semana9.semana9.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PontodeColeta pontodeColeta;

    @ManyToOne
    @JoinColumn(nullable = false)
    private LixoEletronico lixoEletronico;

    @Column(nullable = false)
    private double capacidadeMaxima;
}
