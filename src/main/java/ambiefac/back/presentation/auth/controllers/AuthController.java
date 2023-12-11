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
                return ResponseEntity.status(HttpStatus.OK).body(new RegisterUseCase(this.authRepository).execute(registerUserDto));

            } catch ( UsernameAlreadyExistsException | EmailAlreadyExists e) {
                CustomError error = new CustomError(400,e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }catch (Exception e){
                CustomError error = new CustomError(400,e.getMessage());
                return  ResponseEntity.status(error.getStatus()).body(error);
            }
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@Valid @RequestBody LoginUserDto loginUserDto) {

            try {
                return ResponseEntity.status(HttpStatus.OK).body(new LoginUseCase(this.authRepository).execute(loginUserDto));

            } catch (Exception e) {
                CustomError error = new CustomError(401,e.getMessage());
                return ResponseEntity.status(error.getStatus()).body(error);
            }
        }




}
