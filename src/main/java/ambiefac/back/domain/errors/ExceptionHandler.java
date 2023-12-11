package ambiefac.back.domain.errors;


import org.springframework.http.*;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;



public  class ExceptionHandler  {




    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleConflict(RuntimeException exc, WebRequest web){
        ErrorMessage errorMessage = new ErrorMessage(exc.getMessage());
       return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleConflictSQL(SQLIntegrityConstraintViolationException exc, WebRequest web){
        ErrorMessage errorMessage = new ErrorMessage(exc.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        System.out.println("pasando por la validacion");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity<Object> handleAuthentication(RuntimeException exc){
        String bodyOfResponse = "credentials incorrect";
        System.out.println("Excepción manejada por @ControllerAdvice: " + exc.getMessage());
        return new ResponseEntity<>(bodyOfResponse,HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MissingArgumentException.class)
    public ResponseEntity<Object> handleMissingArgument(MissingArgumentException exc){
        System.out.println("Excepción manejada por @ControllerAdvice: " + exc.getMessage());
        return new ResponseEntity<>(exc.getMessage(),HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<Object> handleMissingArgument(EmailAlreadyExists exc){
        System.out.println("Excepción manejada por @ControllerAdvice: " + exc.getMessage());
        return new ResponseEntity<>(exc.getMessage(),HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler()
    public ResponseEntity<Object> handleCustomErrors(CustomError ex,WebRequest web) {
        //return new ResponseEntity<>(ex.getMessage(), HttpStatusCode.valueOf(ex.getStatus()));
        System.out.println("Excepción manejada por @ControllerAdvice: " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
    }





}