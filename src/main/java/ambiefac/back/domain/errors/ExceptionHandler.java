package ambiefac.back.domain.errors;

import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.sound.midi.InvalidMidiDataException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public  class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleConflict(RuntimeException exc, WebRequest web){
        String bodyOfResponse = "Illegal argument exception error";
        System.out.println(handleExceptionInternal(exc,exc.getMessage(),new HttpHeaders(), HttpStatus.CONFLICT,web));
        return handleExceptionInternal(exc,exc.getMessage(),new HttpHeaders(), HttpStatus.CONFLICT,web);
    }



}