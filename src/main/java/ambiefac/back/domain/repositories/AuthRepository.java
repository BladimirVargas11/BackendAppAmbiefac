package ambiefac.back.domain.repositories;

import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.data.response.ResponseRegisterDto;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class AuthRepository {

    public abstract UserDetails loginCredentials(LoginUserDto loginUserDto);

    public abstract ResponseRegisterDto registerCredentials(RegisterUserDto registerUserDto);
}
