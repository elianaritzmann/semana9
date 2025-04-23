package semana9.semana9.errors;

public class LixoEletronicoNotFoundException extends NotFoundException {
    public LixoEletronicoNotFoundException(Long id) {
        super("Lixo Eletronico", id);
    }
}
