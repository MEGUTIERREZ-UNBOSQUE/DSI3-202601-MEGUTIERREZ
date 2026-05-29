package com.mesaya.cliente.service.interfaz;

import com.mesaya.cliente.dto.ClienteDTO.*;
import java.util.List;

public interface IClienteService {
    List<Response> listar(String busqueda);
    Response obtenerPorId(Long id);
    Response crear(Request dto);
    Response actualizar(Long id, Request dto);
    void eliminar(Long id);
}
