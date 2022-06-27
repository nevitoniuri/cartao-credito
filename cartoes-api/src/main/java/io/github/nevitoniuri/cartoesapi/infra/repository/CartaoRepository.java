package io.github.nevitoniuri.cartoesapi.infra.repository;

import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    List<Cartao> findByRendaMinimaLessThanEqual(BigDecimal renda);

    Optional<Cartao> findByNome(String nome);

}
