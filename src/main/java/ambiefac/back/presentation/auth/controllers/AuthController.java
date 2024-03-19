package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.auth.LoginUserDto;
import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.domain.errors.CustomError;
import ambiefac.back.domain.errors.EmailAlreadyExists;
import ambiefac.back.domain.errors.UsernameAlreadyExistsException;
import ambiefac.back.domain.repositories.AuthRepository;
import ambiefac.back.domain.useCases.auth.LoginUseCase;
import ambiefac.back.domain.useCases.auth.RegisterUseCase;
import ambiefac.back.presentation.auth.services.AuthService;
import ambiefac.back.util.Response;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
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
                var result = new RegisterUseCase(this.authRepository).execute(registerUserDto);
                Response<?> response = new Response<>(true,"Registro exitoso", result);
                return ResponseEntity.status(HttpStatus.OK).body(response);

            } catch (Exception e){
                CustomError error = new CustomError(400,e.getMessage());
                Response<?> response = new Response<>(false,error.getMessage(), error);
                return ResponseEntity.status(error.getStatus()).body(response);
            }
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@Valid @RequestBody LoginUserDto loginUserDto) {

            try {

                return ResponseEntity.status(200).body(new LoginUseCase(this.authRepository).execute(loginUserDto));

            } catch (Exception e) {
                CustomError error = new CustomError(401,e.getMessage());
                Response<?> response = new Response<>(false,error.getMessage(), error);
                return ResponseEntity.status(error.getStatus()).body(response);
            }
        }




}
