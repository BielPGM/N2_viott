package me.biel.loja.exceptions;

public class ProdutoNotFound  extends Exception{

    public ProdutoNotFound(String messageError, Throwable err)
    {
        super(messageError, err);
    }

}