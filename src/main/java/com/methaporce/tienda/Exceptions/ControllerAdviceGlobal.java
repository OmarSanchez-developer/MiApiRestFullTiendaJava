package com.methaporce.tienda.Exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdviceGlobal {
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<?> manejarListaDeErroresdeValidacion(MethodArgumentNotValidException exception){
        Map<String,String> errores = new HashMap<>();
        for (FieldError error : exception.getFieldErrors()) {
            errores.put(error.getField(),error.getDefaultMessage());

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }

    //ExceptionsHandlerException
    @ExceptionHandler(ClienteNotFoundException.class)

    //Creamos metodo para responder esta exception

    public ResponseEntity<?> manejarClienteNoEncontrado(ClienteNotFoundException clienteNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteNotFoundException.getMessage());
    }
}
