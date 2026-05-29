package com.mesaya.mesa.service.impl;

import com.mesaya.exception.*;
import com.mesaya.mesa.dto.MesaDTO.*;
import com.mesaya.mesa.service.interfaz.IMesaService;
import com.mesaya.model.entity.Mesa;
import com.mesaya.model.entity.Mesa.EstadoMesa;
import com.mesaya.model.entity.Pedido.EstadoPedido;
import com.mesaya.repository.MesaRepository;
import com.mesaya.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MesaServiceImpl implements IMesaService {

    private final MesaRepository  mesaRepository;
    private final PedidoRepository pedidoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Response> listar(EstadoMesa estado) {
        List<Mesa> lista = (estado != null)
                ? mesaRepository.findByEstado(estado)
                : mesaRepository.findAll();
        return lista.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Response obtenerPorId(Long id) {
        return toResponse(buscar(id));
    }

    @Override
    @Transactional
    public Response crear(Request dto) {
        if (mesaRepository.existsByNumero(dto.getNumero()))
            throw new BusinessException("Ya existe una mesa con el número " + dto.getNumero());
        Mesa m = new Mesa();
        mapear(dto, m);
        return toResponse(mesaRepository.save(m));
    }

    @Override
    @Transactional
    public Response actualizar(Long id, Request dto) {
        Mesa m = buscar(id);
        if (mesaRepository.existsByNumeroAndIdMesaNot(dto.getNumero(), id))
            throw new BusinessException("Ya existe otra mesa con el número " + dto.getNumero());
        mapear(dto, m);
        return toResponse(mesaRepository.save(m));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        buscar(id);
        boolean activa = pedidoRepository.existsByMesaIdMesaAndEstadoIn(
                id, List.of(EstadoPedido.CREADA, EstadoPedido.EN_PREPARACION));
        if (activa)
            throw new BusinessException("La mesa tiene pedidos activos y no puede eliminarse.");
        mesaRepository.deleteById(id);
    }

    // ── helpers ──────────────────────────────────────────────────────────────
    private Mesa buscar(Long id) {
        return mesaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mesa no encontrada: " + id));
    }

    private void mapear(Request dto, Mesa m) {
        m.setNumero(dto.getNumero());
        m.setCapacidad(dto.getCapacidad());
        m.setEstado(dto.getEstado() != null ? dto.getEstado() : EstadoMesa.DISPONIBLE);
    }

    private Response toResponse(Mesa m) {
        return new Response(m.getIdMesa(), m.getNumero(), m.getCapacidad(), m.getEstado());
    }
}
