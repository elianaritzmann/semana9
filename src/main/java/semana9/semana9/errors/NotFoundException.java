package semana9.semana9.errors;

public abstract class NotFoundException extends RuntimeException {
    public NotFoundException(String objectName, Long id) {
        super(objectName+"' com id '"+ id + "'não encontrado'");
    }
}
