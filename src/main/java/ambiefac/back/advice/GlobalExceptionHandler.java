package ambiefac.back.advice;

import ambiefac.back.domain.errors.CustomError;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationExceptionSQL(SQLIntegrityConstraintViolationException exception) {
        CustomError customError = new CustomError(400,exception.getMessage());
        return ResponseEntity.status(400).body(customError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataViolation(DataIntegrityViolationException exception) {
        CustomError customError = new CustomError(400,Objects.requireNonNull(exception.getRootCause()).getMessage());
        return ResponseEntity.status(customError.getStatus()).body(customError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleViolationException(ConstraintViolationException exception) {
        Map<String, Object> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(propertyPath, message);
        }
        CustomError customError = new CustomError(400, String.valueOf(errors));
        return ResponseEntity.status(400).body(customError);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeException(RuntimeException exception) {
        CustomError customError = new CustomError(400,exception.getMessage());
        return ResponseEntity.status(400).body(customError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomError> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        Map<String, Object> errorResponse = new HashMap<>();
        result.getFieldErrors().forEach(fieldError ->
                errorResponse.put(fieldError.getField(), fieldError.getDefaultMessage()));
        CustomError customError = new CustomError(400,errorResponse.toString());
        return ResponseEntity.badRequest().body(customError);
    }

    @ExceptionHandler(ClaimJwtException.class)
    public ResponseEntity<?> handleExpiredJWT(ClaimJwtException exception){
        CustomError customError = new CustomError(401, "Jwt expired");
        return ResponseEntity.status(customError.getStatus()).body(customError);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<?> handleExpiredJWTException(JwtException exception){
        CustomError customError = new CustomError(401, "Jwt expired");
        return ResponseEntity.status(customError.getStatus()).body(customError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomError> handleEntityNotFoundException(EntityNotFoundException ex) {
        CustomError customError = new CustomError(404,ex.getMessage());
        return ResponseEntity.status(customError.getStatus()).body(customError);
    }

    @ExceptionHandler(MalformedJwtException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomError> handleEntityNotFoundException(MalformedJwtException ex) {
        CustomError customError = new CustomError(404,ex.getMessage());
        return ResponseEntity.status(customError.getStatus()).body(customError);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleNullPointer(NullPointerException nullPointerException) {
        CustomError customError = new CustomError(400,nullPointerException.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customError);
    }
}
