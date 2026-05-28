package com.mesaya.pedido.service.impl;

import com.mesaya.exception.*;
import com.mesaya.model.entity.*;
import com.mesaya.model.entity.Mesa.EstadoMesa;
import com.mesaya.model.entity.Pedido.EstadoPedido;
import com.mesaya.pedido.dto.PedidoDTO.*;
import com.mesaya.pedido.service.interfaz.IPedidoService;
import com.mesaya.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements IPedidoService {

    private final PedidoRepository         pedidoRepository;
    private final MesaRepository           mesaRepository;
    private final ClienteRepository        clienteRepository;
    private final UsuarioRepository        usuarioRepository;
    private final ProductoRepository       productoRepository;
    private final DetallePedidoRepository  detallePedidoRepository;

    // ── Listar ───────────────────────────────────────────────────────────────
    @Override
    @Transactional(readOnly = true)
    public List<Response> listar(EstadoPedido estado) {
        List<Pedido> lista = (estado != null)
                ? pedidoRepository.findByEstado(estado)
                : pedidoRepository.findAll();
        return lista.stream().map(this::toResponse).collect(Collectors.toList());
    }

    // ── Detalle ───────────────────────────────────────────────────────────────
    @Override
    @Transactional(readOnly = true)
    public Response obtenerPorId(Long id) {
        return toResponse(buscar(id));
    }

    // ── Crear ─────────────────────────────────────────────────────────────────
    @Override
    @Transactional
    public Response crear(CrearRequest dto) {
        Mesa mesa = mesaRepository.findById(dto.getIdMesa())
                .orElseThrow(() -> new ResourceNotFoundException("Mesa no encontrada: " + dto.getIdMesa()));

        if (mesa.getEstado() == EstadoMesa.OCUPADA)
            throw new BusinessException("La mesa " + mesa.getNumero() + " ya está ocupada.");

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + dto.getIdUsuario()));

        Cliente cliente = null;
        if (dto.getIdCliente() != null) {
            cliente = clienteRepository.findById(dto.getIdCliente())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + dto.getIdCliente()));
        }

        Pedido pedido = new Pedido();
        pedido.setMesa(mesa);
        pedido.setCliente(cliente);
        pedido.setUsuario(usuario);
        pedido.setObservaciones(dto.getObservaciones());
        pedido.setEstado(EstadoPedido.CREADA);

        // Guardar primero para obtener el id y poder hacer FK en detalles
        Pedido guardado = pedidoRepository.save(pedido);

        for (CrearRequest.ItemRequest item : dto.getItems()) {
            Producto producto = productoRepository.findById(item.getIdProducto())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado: " + item.getIdProducto()));
            if (!producto.getDisponible())
                throw new BusinessException("El producto '" + producto.getNombre() + "' no está disponible.");

            DetallePedido detalle = new DetallePedido();
            detalle.setPedido(guardado);
            detalle.setProducto(producto);
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setSubtotal(producto.getPrecio() * item.getCantidad());
            guardado.getDetalles().add(detalle);
        }

        // Marcar mesa como OCUPADA
        mesa.setEstado(EstadoMesa.OCUPADA);
        mesaRepository.save(mesa);

        return toResponse(pedidoRepository.save(guardado));
    }

    // ── Eliminar ──────────────────────────────────────────────────────────────
    @Override
    @Transactional
    public void eliminar(Long id) {
        Pedido pedido = buscar(id);
        if (pedido.getEstado() != EstadoPedido.CREADA)
            throw new BusinessException("Solo se pueden eliminar pedidos en estado CREADA.");
        // Liberar mesa
        pedido.getMesa().setEstado(EstadoMesa.DISPONIBLE);
        mesaRepository.save(pedido.getMesa());
        pedidoRepository.deleteById(id);
    }

    // ── Avanzar estado ────────────────────────────────────────────────────────
    @Override
    @Transactional
    public Response avanzarEstado(Long id) {
        Pedido pedido = buscar(id);
        EstadoPedido siguiente = pedido.getEstado().siguiente();
        pedido.setEstado(siguiente);

        if (siguiente == EstadoPedido.ENTREGADA) {
            pedido.getMesa().setEstado(EstadoMesa.DISPONIBLE);
            mesaRepository.save(pedido.getMesa());
        }
        return toResponse(pedidoRepository.save(pedido));
    }

    // ── Agregar detalle ───────────────────────────────────────────────────────
    @Override
    @Transactional
    public Response agregarDetalle(Long idPedido, AgregarDetalleRequest dto) {
        Pedido pedido = buscar(idPedido);
        Producto producto = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado: " + dto.getIdProducto()));
        if (!producto.getDisponible())
            throw new BusinessException("El producto '" + producto.getNombre() + "' no está disponible.");

        DetallePedido detalle = new DetallePedido();
        detalle.setPedido(pedido);
        detalle.setProducto(producto);
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(producto.getPrecio());
        detalle.setSubtotal(producto.getPrecio() * dto.getCantidad());
        pedido.getDetalles().add(detalle);

        return toResponse(pedidoRepository.save(pedido));
    }

    // ── Eliminar detalle ──────────────────────────────────────────────────────
    @Override
    @Transactional
    public Response eliminarDetalle(Long idPedido, Long idDetalle) {
        Pedido pedido = buscar(idPedido);
        if (pedido.getEstado() != EstadoPedido.CREADA)
            throw new BusinessException("Solo se pueden quitar ítems de pedidos en estado CREADA.");

        DetallePedido detalle = detallePedidoRepository.findById(idDetalle)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle no encontrado: " + idDetalle));

        pedido.getDetalles().remove(detalle);
        return toResponse(pedidoRepository.save(pedido));
    }

    // ── Helpers ───────────────────────────────────────────────────────────────
    private Pedido buscar(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado: " + id));
    }

    private Response toResponse(Pedido p) {
        List<DetalleResponse> detalles = p.getDetalles().stream()
                .map(d -> new DetalleResponse(
                        d.getIdDetalle(),
                        d.getProducto().getIdProducto(),
                        d.getProducto().getNombre(),
                        d.getCantidad(),
                        d.getPrecioUnitario(),
                        d.getSubtotal()))
                .collect(Collectors.toList());

        double total = p.getDetalles().stream()
                .mapToDouble(DetallePedido::getSubtotal).sum();

        return new Response(
                p.getIdPedido(),
                p.getMesa().getIdMesa(),
                p.getMesa().getNumero(),
                p.getCliente() != null ? p.getCliente().getIdCliente() : null,
                p.getCliente() != null ? p.getCliente().getNombre()   : null,
                p.getUsuario().getIdUsuario(),
                p.getUsuario().getNombre(),
                p.getFechaCreacion(),
                p.getEstado(),
                p.getObservaciones(),
                total,
                detalles);
    }
}
