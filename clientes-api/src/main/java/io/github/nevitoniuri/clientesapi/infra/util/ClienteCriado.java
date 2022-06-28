package io.github.nevitoniuri.clientesapi.infra.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClienteCriado {
    public static URI location(String cpf) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{cpf}")
                .query("cpf={cpf}")
                .buildAndExpand(cpf).toUri();
    }
}
