package io.github.nevitoniuri.cartoesapi.application;

import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import io.github.nevitoniuri.cartoesapi.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository repository;

    @Transactional
    public void salvar(Cartao cartao) {
        repository.save(cartao);
    }

    public List<Cartao> buscarPorRendaMenorIgual(Long value) {
        BigDecimal renda = BigDecimal.valueOf(value);
        return repository.findByRendaLessThanEqual(renda);
    }
}
