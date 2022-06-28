package io.github.nevitoniuri.clientesapi.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends BadRequestException {
    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado");
    }
}
