package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.auth.RegisterUserDto;
import ambiefac.back.domain.entities.CredentialEntity;
import ambiefac.back.presentation.auth.services.AuthService;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

        private  final AuthService authService;

        public AuthController(AuthService authService){
            this.authService = authService;
        }

        @PostMapping("/register")
        public ResponseEntity<CredentialEntity> register(@Valid  @RequestBody RegisterUserDto registerUserDto){
            CredentialEntity credential = authService.registerCredentials(registerUserDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(credential);
        }





}
