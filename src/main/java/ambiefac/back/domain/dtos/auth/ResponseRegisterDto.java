package ambiefac.back.domain.dtos.auth;

import ambiefac.back.domain.entities.ClientEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ResponseRegisterDto {
    
    private ClientEntity client;

    public ResponseRegisterDto(ClientEntity client) {
        this.client = client;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
