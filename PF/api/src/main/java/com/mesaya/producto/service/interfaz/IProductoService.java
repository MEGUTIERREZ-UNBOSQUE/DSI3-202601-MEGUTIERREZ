package com.mesaya.producto.service.interfaz;

import com.mesaya.producto.dto.ProductoDTO.*;
import java.util.List;

public interface IProductoService {
    List<Response> listar(String categoria, Boolean disponible);
    Response obtenerPorId(Long id);
    Response crear(Request dto);
    Response actualizar(Long id, Request dto);
    void eliminar(Long id);
}
