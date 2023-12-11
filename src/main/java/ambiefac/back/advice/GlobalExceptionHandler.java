package ambiefac.back.advice;

import ambiefac.back.domain.errors.CustomError;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
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
        System.out.println("pasa por aca: "+exception.getClass());
        return ResponseEntity.status(400).body(exception.getMessage());
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
        return ResponseEntity.status(400).body(errors);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeException(RuntimeException exception) {
        System.out.println("pasa por aca: "+exception.getClass());
        return ResponseEntity.status(400).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", "La solicitud contiene errores de validación");
        result.getFieldErrors().forEach(fieldError ->
                errorResponse.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errorResponse);
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

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleNullPointer(NullPointerException nullPointerException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(nullPointerException.getMessage());
    }
}
