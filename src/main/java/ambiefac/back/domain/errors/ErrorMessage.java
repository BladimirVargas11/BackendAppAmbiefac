package ambiefac.back.domain.errors;

import io.swagger.models.auth.In;

import java.util.List;

public class ErrorMessage {

    private String error;

    public ErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}


