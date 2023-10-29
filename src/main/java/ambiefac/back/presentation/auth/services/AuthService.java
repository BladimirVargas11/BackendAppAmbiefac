package ambiefac.back.presentation.auth.services;

import ambiefac.back.domain.datasources.AuthDatasource;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private  final AuthDatasource authDatasource;

    public  AuthService(AuthDatasource authDatasource){
        this.authDatasource = authDatasource;
    }

    public CredentialEntity registerCredentials(RegisterUserDto registerUserDto){
        return authDatasource.registerCredentials(registerUserDto);
    }
}
