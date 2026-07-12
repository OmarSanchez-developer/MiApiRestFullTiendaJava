package com.methaporce.tienda.Exceptions;


public class  ClienteNotFoundException extends RuntimeException {
    //Constructor

    public ClienteNotFoundException(String mensaje){
        super(mensaje);
    }
}
