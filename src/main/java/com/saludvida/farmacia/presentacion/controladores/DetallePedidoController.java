package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IDetallePedidoUseCase;
import com.saludvida.farmacia.presentacion.dto.request.DetallePedidoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.DetallePedidoResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IDetallePedidoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoController {

    private final IDetallePedidoUseCase detallePedidoUseCase;
    private final IDetallePedidoDtoMapper mapper;

    public DetallePedidoController(IDetallePedidoUseCase detallePedidoUseCase, IDetallePedidoDtoMapper mapper) {
        this.detallePedidoUseCase = detallePedidoUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetallePedidoResponseDTO guardar(@Valid @RequestBody DetallePedidoRequestDTO request) {
        return mapper.toResponse(detallePedidoUseCase.guardar(mapper.toDomain(request)));
    }

    @GetMapping
    public List<DetallePedidoResponseDTO> listar() {
        return detallePedidoUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoResponseDTO> buscarPorId(@PathVariable long id) {
        return detallePedidoUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pedido/{idPedido}")
    public List<DetallePedidoResponseDTO> buscarPorPedido(@PathVariable long idPedido) {
        return detallePedidoUseCase.buscarPorPedido(idPedido)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/producto/{idProducto}")
    public List<DetallePedidoResponseDTO> buscarPorProducto(@PathVariable long idProducto) {
        return detallePedidoUseCase.buscarPorProducto(idProducto)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}