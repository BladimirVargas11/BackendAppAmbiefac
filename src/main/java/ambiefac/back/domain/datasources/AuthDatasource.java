package ambiefac.back.domain.datasources;

import ambiefac.back.config.jwt.JWTService;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.repositories.AuthRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AuthDatasource {

    private  final AuthRepository authRepository;
    private  final JWTService  jwtService;
    private final BCryptPasswordEncoder encoder;
    public AuthDatasource(AuthRepository authRepository,JWTService jwtService,BCryptPasswordEncoder encoder){
        this.authRepository = authRepository;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    public CredentialEntity registerCredentials(RegisterUserDto registerUserDto){
        final String token = jwtService.getToken(registerUserDto);
        CredentialEntity credentialEntity = new CredentialEntity
                (null,registerUserDto.getUsername(),  encoder.encode(registerUserDto.getPassword()),registerUserDto.getEmail(),token);
        System.out.println(credentialEntity);
        return authRepository.save(credentialEntity);
    }




}
