package ambiefac.back.domain.datasources;

import ambiefac.back.config.jwt.JWTService;
import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.repositories.AuthRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AuthDatasource {

    private  final AuthRepository authRepository;
    private  final JWTService  jwtService;
    private final BCryptPasswordEncoder encoder;
    private  final AuthenticationManager authenticationManager;

    public AuthDatasource(AuthRepository authRepository, JWTService jwtService, BCryptPasswordEncoder encoder, AuthenticationManager authenticationManager){
        this.authRepository = authRepository;
        this.jwtService = jwtService;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
    }

    public UserDetails loginCredentials(LoginUserDto loginUserDto){
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUserDto.getUsername(),loginUserDto.getPassword()));
        UserDetails user = authRepository.findByUsername(loginUserDto.getUsername());
        CredentialEntity newUser = (CredentialEntity) user;
        String token = jwtService.getToken(user);
        newUser.setJWT(token);
        return newUser;
    }

    public CredentialEntity registerCredentials(RegisterUserDto registerUserDto){
        final String token = jwtService.getToken(registerUserDto);
        CredentialEntity credentialEntity = new CredentialEntity
                (null,registerUserDto.getUsername(),  encoder.encode(registerUserDto.getPassword()),registerUserDto.getEmail(),token);
        return authRepository.save(credentialEntity);
    }




}
