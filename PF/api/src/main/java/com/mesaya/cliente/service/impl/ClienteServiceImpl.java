package com.mesaya.cliente.service.impl;

import com.mesaya.cliente.dto.ClienteDTO.*;
import com.mesaya.cliente.service.interfaz.IClienteService;
import com.mesaya.exception.*;
import com.mesaya.model.entity.Cliente;
import com.mesaya.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Response> listar(String busqueda) {
        List<Cliente> lista = (busqueda != null && !busqueda.isBlank())
                ? clienteRepository.buscarPorNombreOEmail(busqueda)
                : clienteRepository.findAll();
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
        if (clienteRepository.existsByEmail(dto.getEmail()))
            throw new BusinessException("Ya existe un cliente con el correo: " + dto.getEmail());
        Cliente c = new Cliente();
        mapear(dto, c);
        return toResponse(clienteRepository.save(c));
    }

    @Override
    @Transactional
    public Response actualizar(Long id, Request dto) {
        Cliente c = buscar(id);
        if (!c.getEmail().equalsIgnoreCase(dto.getEmail())
                && clienteRepository.existsByEmail(dto.getEmail()))
            throw new BusinessException("Ya existe otro cliente con el correo: " + dto.getEmail());
        mapear(dto, c);
        return toResponse(clienteRepository.save(c));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        buscar(id);
        clienteRepository.deleteById(id);
    }

    // ── helpers ──────────────────────────────────────────────────────────────
    private Cliente buscar(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + id));
    }

    private void mapear(Request dto, Cliente c) {
        c.setNombre(dto.getNombre());
        c.setTelefono(dto.getTelefono());
        c.setEmail(dto.getEmail());
    }

    private Response toResponse(Cliente c) {
        return new Response(c.getIdCliente(), c.getNombre(), c.getTelefono(),
                c.getEmail(), c.getFechaRegistro());
    }
}
