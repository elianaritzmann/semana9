package semana9.semana9.errors;

public class PontodeColetaNotFoundException extends NotFoundException {
    public PontodeColetaNotFoundException(Long id) {
        super("PontodeColeta", id);
    }
}
