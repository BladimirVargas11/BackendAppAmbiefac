package ambiefac.back.domain.errors;

public class MissingArgumentException extends RuntimeException{

    public MissingArgumentException(String mensaje) {
        super(mensaje);
    }
}
