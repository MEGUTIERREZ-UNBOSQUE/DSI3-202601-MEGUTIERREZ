package com.mesaya.repository;

import com.mesaya.model.entity.Mesa;
import com.mesaya.model.entity.Mesa.EstadoMesa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
    List<Mesa> findByEstado(EstadoMesa estado);
    long countByEstado(EstadoMesa estado);
    boolean existsByNumero(Integer numero);
    boolean existsByNumeroAndIdMesaNot(Integer numero, Long idMesa);
}
