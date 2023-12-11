package ambiefac.back.domain.useCases.auth;

import ambiefac.back.config.jwt.JWTService;
import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.errors.CustomError;
import ambiefac.back.data.Credential;
import ambiefac.back.domain.repositories.AuthRepository;
import ambiefac.back.infrastructure.datasources.AuthDatasource;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUseCase {

    @Autowired
    private Credential credential;
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private JWTService jwtService;

    public LoginUseCase(AuthRepository authRepository){
        this.authRepository = authRepository;

    }


    public UserDetails execute(LoginUserDto loginUserDto){

        return this.authRepository.loginCredentials(loginUserDto);
    }
}
