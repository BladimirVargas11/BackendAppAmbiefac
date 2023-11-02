package ambiefac.back.presentation.auth.services;

import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.errors.CustomError;
import ambiefac.back.domain.errors.EmailAlreadyExists;
import ambiefac.back.domain.errors.UsernameAlreadyExistsException;
import ambiefac.back.data.Credential;
import ambiefac.back.infrastructure.datasources.AuthDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private  final ambiefac.back.infrastructure.datasources.AuthDatasource authDatasource;
    @Autowired
    private Credential credential;

    public  AuthService(AuthDatasource authDatasource){
        this.authDatasource = authDatasource;
    }

    public UserDetails login(LoginUserDto loginUserDto) throws CustomError {
       return  authDatasource.loginCredentials(loginUserDto);

    }

    public CredentialEntity registerCredentials(RegisterUserDto registerUserDto){
        Optional<CredentialEntity> credential = this.credential.findByEmail(registerUserDto.getEmail());

        if(this.credential.findByEmail(registerUserDto.getEmail()).isPresent()){
            throw new EmailAlreadyExists("El email ya existe");
        }
        if(this.credential.findByUsername(registerUserDto.getUsername()) != null){
            throw new UsernameAlreadyExistsException("Ya existe un usuario con este username");
        }
        return authDatasource.registerCredentials(registerUserDto);
    }
}
