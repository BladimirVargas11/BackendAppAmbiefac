package ambiefac.back.domain.errors;

public class CustomError extends Exception{

    private int status;
    private String message;
    CustomError(int status, String message){
        super(message);
    }

    public static CustomError notFound(String message){
        return new CustomError(404,message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
