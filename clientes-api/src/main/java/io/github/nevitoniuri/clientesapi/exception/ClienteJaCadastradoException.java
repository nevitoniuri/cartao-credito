package io.github.nevitoniuri.clientesapi.exception;

public class ClienteJaCadastradoException extends BadRequestException {
    public ClienteJaCadastradoException() {
        super("Cliente com CPF já cadastrado.");
    }
}

