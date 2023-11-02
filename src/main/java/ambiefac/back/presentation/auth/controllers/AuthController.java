package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.errors.CustomError;
import ambiefac.back.domain.errors.EmailAlreadyExists;
import ambiefac.back.domain.errors.UsernameAlreadyExistsException;
import ambiefac.back.domain.repositories.AuthRepository;
import ambiefac.back.domain.useCases.auth.LoginUseCase;
import ambiefac.back.presentation.auth.services.AuthService;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

        private final AuthRepository authRepository;

        public AuthController(AuthRepository authRepository){
            this.authRepository = authRepository;
        }

        @PostMapping("/register")
        public ResponseEntity<?> register(@Valid  @RequestBody RegisterUserDto registerUserDto) {
            try {
                CredentialEntity credential = authRepository.registerCredentials(registerUserDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(credential);
            } catch (Exception exc) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
            }
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@Valid @RequestBody LoginUserDto loginUserDto) throws CustomError {

            try {
                return ResponseEntity.status(HttpStatus.OK).body(new LoginUseCase(this.authRepository).execute(loginUserDto));

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }
        }




}
