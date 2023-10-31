package ambiefac.back.domain.errors;

public class EmailAlreadyExists extends RuntimeException{

    public EmailAlreadyExists(String message) {
        super(message);
    }
}
