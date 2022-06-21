package io.github.nevitoniuri.cartoesapi.infra.repository;

import io.github.nevitoniuri.cartoesapi.domain.CartaoVinculado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoVinculadoRepository extends JpaRepository<CartaoVinculado, Long> {

    List<CartaoVinculado> findByCpf(String cpf);
}
