package me.biel.loja.exceptions;

public class ClienteNotFound extends Exception{

    public ClienteNotFound(String messageError, Throwable err)
    {
        super(messageError, err);
    }

}
