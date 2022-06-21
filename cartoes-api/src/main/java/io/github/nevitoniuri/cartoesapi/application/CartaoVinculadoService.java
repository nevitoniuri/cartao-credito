package io.github.nevitoniuri.cartoesapi.application;

import io.github.nevitoniuri.cartoesapi.domain.CartaoVinculado;
import io.github.nevitoniuri.cartoesapi.infra.repository.CartaoVinculadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoVinculadoService {

    private final CartaoVinculadoRepository repository;

    public List<CartaoVinculado> listarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
