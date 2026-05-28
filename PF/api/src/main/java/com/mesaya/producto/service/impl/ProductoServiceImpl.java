package com.mesaya.producto.service.impl;

import com.mesaya.exception.ResourceNotFoundException;
import com.mesaya.model.entity.Producto;
import com.mesaya.producto.dto.ProductoDTO.*;
import com.mesaya.producto.service.interfaz.IProductoService;
import com.mesaya.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Response> listar(String categoria, Boolean disponible) {
        List<Producto> lista;
        if (categoria != null && disponible != null)
            lista = productoRepository.findByCategoriaAndDisponible(categoria, disponible);
        else if (categoria != null)
            lista = productoRepository.findByCategoria(categoria);
        else if (disponible != null)
            lista = productoRepository.findByDisponible(disponible);
        else
            lista = productoRepository.findAll();
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
        Producto p = new Producto();
        mapear(dto, p);
        return toResponse(productoRepository.save(p));
    }

    @Override
    @Transactional
    public Response actualizar(Long id, Request dto) {
        Producto p = buscar(id);
        mapear(dto, p);
        return toResponse(productoRepository.save(p));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        buscar(id);
        productoRepository.deleteById(id);
    }

    // ── helpers ──────────────────────────────────────────────────────────────
    private Producto buscar(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado: " + id));
    }

    private void mapear(Request dto, Producto p) {
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setPrecio(dto.getPrecio());
        p.setCategoria(dto.getCategoria());
        p.setImagenUrl(dto.getImagenUrl());
        p.setDisponible(dto.getDisponible());
        p.setStock(dto.getStock());
    }

    private Response toResponse(Producto p) {
        return new Response(p.getIdProducto(), p.getNombre(), p.getDescripcion(),
                p.getPrecio(), p.getCategoria(), p.getImagenUrl(),
                p.getDisponible(), p.getStock());
    }
}
