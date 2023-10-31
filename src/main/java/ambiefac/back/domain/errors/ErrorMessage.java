package ambiefac.back.domain.errors;

public class ErrorMessage {

    private String status;
    private String message;

    public ErrorMessage(String status, String message){
        this.message = message;
        this.status = status;
    }
}
