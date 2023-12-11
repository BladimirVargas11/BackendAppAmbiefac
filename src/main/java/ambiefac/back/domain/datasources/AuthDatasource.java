package ambiefac.back.domain.datasources;

import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.dtos.auth.ResponseRegisterDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.errors.CustomError;
import org.springframework.security.core.userdetails.UserDetails;


public abstract class AuthDatasource {

    public abstract UserDetails loginCredentials(LoginUserDto loginUserDto);

    public abstract ResponseRegisterDto registerCredentials(RegisterUserDto registerUserDto);


}
