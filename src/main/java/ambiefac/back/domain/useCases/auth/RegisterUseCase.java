package ambiefac.back.domain.useCases.auth;

import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.dtos.auth.ResponseRegisterDto;
import ambiefac.back.domain.repositories.AuthRepository;

public class RegisterUseCase {

    private AuthRepository authRepository;

    public RegisterUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public ResponseRegisterDto execute(RegisterUserDto registerUserDto){
        return this.authRepository.registerCredentials(registerUserDto);
    }
}
