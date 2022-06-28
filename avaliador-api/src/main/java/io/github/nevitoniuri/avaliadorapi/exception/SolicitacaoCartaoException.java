package io.github.nevitoniuri.avaliadorapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class SolicitacaoCartaoException extends RuntimeException {
    public SolicitacaoCartaoException(String message) {
        super(message);
    }
}
