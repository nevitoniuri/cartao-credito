package io.github.nevitoniuri.cartoesapi.infra.exception;

public class CartaoJaCadastradoException extends BadRequestException {
    public CartaoJaCadastradoException() {
        super("Cartão já cadastrado.");
    }
}
