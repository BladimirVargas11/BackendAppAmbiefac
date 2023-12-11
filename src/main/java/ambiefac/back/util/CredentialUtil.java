package ambiefac.back.util;

import ambiefac.back.domain.entities.CredentialEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CredentialUtil {

    private CredentialUtil(){}

    public static ResponseEntity getResponseEntity(String message, HttpStatus httpStatus,CredentialEntity credential){

        if(message.isEmpty()){
            return  new ResponseEntity("a",httpStatus);
        }else{
            return new ResponseEntity(credential,httpStatus);
        }

    }
}
