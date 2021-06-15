package me.biel.loja.exceptions;

public class PedidoNotFound  extends Exception{

    public PedidoNotFound(String messageError, Throwable err)
    {
        super(messageError, err);
    }

}