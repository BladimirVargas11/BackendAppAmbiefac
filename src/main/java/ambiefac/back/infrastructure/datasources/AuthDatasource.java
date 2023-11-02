package ambiefac.back.infrastructure.datasources;

import ambiefac.back.config.jwt.JWTService;
import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.entities.RoleEntity;
import ambiefac.back.domain.errors.CustomError;
import ambiefac.back.data.Credential;
import ambiefac.back.data.Role;
import ambiefac.back.domain.errors.EmailNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthDatasource extends ambiefac.back.domain.datasources.AuthDatasource {

    private  final Credential credential;
    private final Role role;
    private  final JWTService  jwtService;
    private final BCryptPasswordEncoder encoder;
    private  final AuthenticationManager authenticationManager;

    public AuthDatasource(Credential credential, Role role, JWTService jwtService, BCryptPasswordEncoder encoder, AuthenticationManager authenticationManager){
        this.credential = credential;
        this.role = role;
        this.jwtService = jwtService;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
    }

    public UserDetails loginCredentials(LoginUserDto loginUserDto) throws CustomError {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUserDto.getUsername(),loginUserDto.getPassword()));
            UserDetails user = credential.findByUsername(loginUserDto.getUsername());
            if(user==null){
                throw new EmailNotFoundException("User no exists");
            }
            CredentialEntity newUser = (CredentialEntity) user;
            String token = jwtService.getToken(user);
            newUser.setJWT(token);
            return newUser;
        }catch (Exception e){
            throw new InternalAuthenticationServiceException("Error al intentar autenticarse");
        }
    }

    public CredentialEntity registerCredentials(RegisterUserDto registerUserDto){
        final String token = jwtService.getToken(registerUserDto);
        RoleEntity role = new RoleEntity(2,"CLIENT");
        System.out.println(role);
        CredentialEntity credentialEntity = new CredentialEntity
                (null,registerUserDto.getUsername(),  encoder.encode(registerUserDto.getPassword()),
                        registerUserDto.getEmail(),role,token);

        return credential.save(credentialEntity);
    }

}
