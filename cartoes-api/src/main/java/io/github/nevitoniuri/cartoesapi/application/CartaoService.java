package io.github.nevitoniuri.cartoesapi.application;

import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import io.github.nevitoniuri.cartoesapi.infra.exception.CartaoJaCadastradoException;
import io.github.nevitoniuri.cartoesapi.infra.exception.CartaoNaoEncontradoException;
import io.github.nevitoniuri.cartoesapi.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository repository;

    public Cartao findById(Long id) {
        return repository.findById(id).orElseThrow(CartaoNaoEncontradoException::new);
    }

    public void verificaExiste(Cartao cartao) {
        Optional<Cartao> optionalCartao = repository.findByNome(cartao.getNome());
        if (optionalCartao.isPresent()) {
            throw new CartaoJaCadastradoException();
        }
    }

    @Transactional
    public void salvar(Cartao cartao) {
        verificaExiste(cartao);
        repository.save(cartao);
    }

    public List<Cartao> buscarPorRendaMenorIgual(Long value) {
        BigDecimal renda = BigDecimal.valueOf(value);
        return repository.findByRendaMinimaLessThanEqual(renda);
    }
}
