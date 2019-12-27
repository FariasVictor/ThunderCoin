package com.invillia.ThunderCoin.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(final String message){
        super(message + " não encontrado(a)");
    }
}
