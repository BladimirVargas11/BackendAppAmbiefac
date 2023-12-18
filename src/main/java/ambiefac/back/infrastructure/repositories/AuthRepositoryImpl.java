package ambiefac.back.infrastructure.repositories;

import ambiefac.back.domain.datasources.AuthDatasource;
import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.data.response.ResponseRegisterDto;
import ambiefac.back.domain.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthRepositoryImpl extends AuthRepository {

    @Autowired
    private AuthDatasource authDatasource;
    @Override
    public UserDetails loginCredentials(LoginUserDto loginUserDto) {
        return this.authDatasource.loginCredentials(loginUserDto);
    }

    @Override
    public ResponseRegisterDto registerCredentials(RegisterUserDto registerUserDto) {
        return this.authDatasource.registerCredentials(registerUserDto);
    }
}
