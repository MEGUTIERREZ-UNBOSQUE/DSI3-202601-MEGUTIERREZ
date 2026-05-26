package com.mesaya.mesa.service.interfaz;

import com.mesaya.mesa.dto.MesaDTO.*;
import com.mesaya.model.entity.Mesa.EstadoMesa;
import java.util.List;

public interface IMesaService {
    List<Response> listar(EstadoMesa estado);
    Response obtenerPorId(Long id);
    Response crear(Request dto);
    Response actualizar(Long id, Request dto);
    void eliminar(Long id);
}
