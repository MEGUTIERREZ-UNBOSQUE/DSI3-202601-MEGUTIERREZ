package com.mesaya.pedido.service.interfaz;

import com.mesaya.model.entity.Pedido.EstadoPedido;
import com.mesaya.pedido.dto.PedidoDTO.*;
import java.util.List;

public interface IPedidoService {
    List<Response> listar(EstadoPedido estado);
    Response obtenerPorId(Long id);
    Response crear(CrearRequest dto);
    void eliminar(Long id);
    Response avanzarEstado(Long id);
    Response agregarDetalle(Long idPedido, AgregarDetalleRequest dto);
    Response eliminarDetalle(Long idPedido, Long idDetalle);
}
