package io.github.nevitoniuri.clientesapi.application.request;

import io.github.nevitoniuri.clientesapi.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toCliente() {
        return new Cliente(cpf, nome, idade);
    }
}
