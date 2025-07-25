package paolooliviero.demo.Exceptions;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHandlers{
    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<String> notFound(ConfigDataResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } }

