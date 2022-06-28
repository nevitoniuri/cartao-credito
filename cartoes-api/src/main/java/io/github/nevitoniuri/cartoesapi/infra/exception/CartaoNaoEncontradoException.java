package io.github.nevitoniuri.cartoesapi.infra.exception;

public class CartaoNaoEncontradoException extends RuntimeException {
    public CartaoNaoEncontradoException() {
        super("Cartão não encontrado.");
    }
}
