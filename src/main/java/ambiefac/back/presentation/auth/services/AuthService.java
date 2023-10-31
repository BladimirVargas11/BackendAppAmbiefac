package ambiefac.back.presentation.auth.services;

import ambiefac.back.domain.datasources.AuthDatasource;
import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.errors.EmailAlreadyExists;
import ambiefac.back.domain.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private  final AuthDatasource authDatasource;
    @Autowired
    private AuthRepository authRepository;

    public  AuthService(AuthDatasource authDatasource){
        this.authDatasource = authDatasource;
    }

    public UserDetails login(LoginUserDto loginUserDto){
       return  authDatasource.loginCredentials(loginUserDto);

    }

    public CredentialEntity registerCredentials(RegisterUserDto registerUserDto){
        Optional<CredentialEntity> credential = authRepository.findByEmail(registerUserDto.getEmail());

        if(authRepository.findByEmail(registerUserDto.getEmail()).isPresent()){
            throw new EmailAlreadyExists("El email ya existe");
        }
        return authDatasource.registerCredentials(registerUserDto);
    }
}
