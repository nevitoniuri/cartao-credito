package io.github.nevitoniuri.clientesapi.application;

import io.github.nevitoniuri.clientesapi.domain.Cliente;
import io.github.nevitoniuri.clientesapi.infra.exception.ClienteJaCadastradoException;
import io.github.nevitoniuri.clientesapi.infra.exception.ClienteNaoEncontradoException;
import io.github.nevitoniuri.clientesapi.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public Cliente buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(ClienteNaoEncontradoException::new);
    }

    public void verificaExiste(Cliente cliente) {
        Optional<Cliente> optionalCliente = repository.findByCpf(cliente.getCpf());
        if (optionalCliente.isPresent()) {
            throw new ClienteJaCadastradoException();
        }
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        verificaExiste(cliente);
        return repository.save(cliente);
    }

}
