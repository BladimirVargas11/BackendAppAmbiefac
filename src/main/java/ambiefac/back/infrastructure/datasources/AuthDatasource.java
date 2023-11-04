package ambiefac.back.infrastructure.datasources;

import ambiefac.back.config.jwt.JWTService;
import ambiefac.back.data.Client;
import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.dtos.auth.ResponseRegisterDto;
import ambiefac.back.domain.entities.ClientEntity;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.entities.RoleEntity;
import ambiefac.back.domain.errors.CustomError;
import ambiefac.back.data.Credential;
import ambiefac.back.data.Role;
import ambiefac.back.domain.errors.EmailAlreadyExists;
import ambiefac.back.domain.errors.EmailNotFoundException;
import ambiefac.back.domain.errors.UsernameAlreadyExistsException;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthDatasource extends ambiefac.back.domain.datasources.AuthDatasource {

    private  final Credential credential;
    private final Client clientRepository;
    private final Role role;
    private  final JWTService  jwtService;
    private final BCryptPasswordEncoder encoder;
    private  final AuthenticationManager authenticationManager;

    public AuthDatasource(Credential credential, Client client, Role role, JWTService jwtService, BCryptPasswordEncoder encoder, AuthenticationManager authenticationManager){
        this.credential = credential;
        this.clientRepository = client;
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

    @Transactional
    public ResponseRegisterDto registerCredentials(RegisterUserDto registerUserDto) {
        try {
            final String token = jwtService.getToken(registerUserDto);
            RoleEntity role = new RoleEntity(2, "CLIENT");

            if(this.credential.findByEmail(registerUserDto.getEmail()).isPresent()){
                throw new EmailAlreadyExists("El email ya existe");
            }
            if(this.credential.findByUsername(registerUserDto.getUsername()) != null){
                throw new UsernameAlreadyExistsException("Ya existe un usuario con este username");
            }

            CredentialEntity credentialEntity = new CredentialEntity
                    (null, registerUserDto.getUsername(), encoder.encode(registerUserDto.getPassword()),
                            registerUserDto.getEmail(), role, token);
            credential.save(credentialEntity);

            ClientEntity client = new ClientEntity();
            client.setFullName(registerUserDto.getClient().getFullName());
            client.setCredentials(credentialEntity);
            clientRepository.save(client);

            return new ResponseRegisterDto(client);

        } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
        }

    }


}
