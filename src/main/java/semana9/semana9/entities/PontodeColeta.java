package semana9.semana9.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class PontodeColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nome;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private LocalDate diadeColeta;

    @OneToMany(mappedBy = "pontodeColeta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Material> MateriaisAceitosnoPonto = new ArrayList<>();

}
