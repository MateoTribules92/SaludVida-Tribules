package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IPedidoUseCase;
import com.saludvida.farmacia.dominio.entidades.EstadoPedido;
import com.saludvida.farmacia.presentacion.dto.request.PedidoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.PedidoResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IPedidoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final IPedidoUseCase pedidoUseCase;
    private final IPedidoDtoMapper mapper;

    public PedidoController(IPedidoUseCase pedidoUseCase, IPedidoDtoMapper mapper) {
        this.pedidoUseCase = pedidoUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponseDTO crear(@Valid @RequestBody PedidoRequestDTO request) {
        return mapper.toResponse(pedidoUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<PedidoResponseDTO> listar() {
        return pedidoUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPorId(@PathVariable long id) {
        return pedidoUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public PedidoResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody PedidoRequestDTO request) {
        return mapper.toResponse(pedidoUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable long id, @RequestParam EstadoPedido estado) {
        pedidoUseCase.cambiarEstado(id, estado);
        return ResponseEntity.noContent().build();
    }
}
