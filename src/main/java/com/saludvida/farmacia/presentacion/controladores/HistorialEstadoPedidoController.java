package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IHistorialEstadoPedidoUseCase;
import com.saludvida.farmacia.presentacion.dto.request.HistorialEstadoPedidoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.HistorialEstadoPedidoResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IHistorialEstadoPedidoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/historial-estados-pedido")
public class HistorialEstadoPedidoController {

    private final IHistorialEstadoPedidoUseCase historialEstadoPedidoUseCase;
    private final IHistorialEstadoPedidoDtoMapper mapper;

    public HistorialEstadoPedidoController(
            IHistorialEstadoPedidoUseCase historialEstadoPedidoUseCase,
            IHistorialEstadoPedidoDtoMapper mapper) {
        this.historialEstadoPedidoUseCase = historialEstadoPedidoUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HistorialEstadoPedidoResponseDTO registrar(@Valid @RequestBody HistorialEstadoPedidoRequestDTO request) {
        return mapper.toResponse(historialEstadoPedidoUseCase.registrar(mapper.toDomain(request)));
    }

    @GetMapping
    public List<HistorialEstadoPedidoResponseDTO> listar() {
        return historialEstadoPedidoUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialEstadoPedidoResponseDTO> buscarPorId(@PathVariable long id) {
        return historialEstadoPedidoUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pedido/{idPedido}")
    public List<HistorialEstadoPedidoResponseDTO> buscarPorPedido(@PathVariable long idPedido) {
        return historialEstadoPedidoUseCase.buscarPorPedido(idPedido)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<HistorialEstadoPedidoResponseDTO> buscarPorUsuario(@PathVariable long idUsuario) {
        return historialEstadoPedidoUseCase.buscarPorUsuario(idUsuario)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}