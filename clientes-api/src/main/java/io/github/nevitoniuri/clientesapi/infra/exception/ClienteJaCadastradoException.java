package io.github.nevitoniuri.clientesapi.infra.exception;

public class ClienteJaCadastradoException extends BadRequestException {
    public ClienteJaCadastradoException() {
        super("Cliente com CPF já cadastrado.");
    }
}

