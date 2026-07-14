package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IRutaPedidoUseCase;
import com.saludvida.farmacia.presentacion.dto.request.RutaPedidoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.RutaPedidoResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IRutaPedidoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ruta-pedidos")
public class RutaPedidoController {

    private final IRutaPedidoUseCase rutaPedidoUseCase;
    private final IRutaPedidoDtoMapper mapper;

    public RutaPedidoController(IRutaPedidoUseCase rutaPedidoUseCase, IRutaPedidoDtoMapper mapper) {
        this.rutaPedidoUseCase = rutaPedidoUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RutaPedidoResponseDTO asignar(@Valid @RequestBody RutaPedidoRequestDTO request) {
        return mapper.toResponse(rutaPedidoUseCase.asignar(mapper.toDomain(request)));
    }

    @GetMapping
    public List<RutaPedidoResponseDTO> listar() {
        return rutaPedidoUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaPedidoResponseDTO> buscarPorId(@PathVariable long id) {
        return rutaPedidoUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ruta/{idRuta}")
    public List<RutaPedidoResponseDTO> buscarPorRuta(@PathVariable long idRuta) {
        return rutaPedidoUseCase.buscarPorRuta(idRuta)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/pedido/{idPedido}")
    public List<RutaPedidoResponseDTO> buscarPorPedido(@PathVariable long idPedido) {
        return rutaPedidoUseCase.buscarPorPedido(idPedido)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/ruta/{idRuta}/pedido/{idPedido}")
    public ResponseEntity<RutaPedidoResponseDTO> buscarPorRutaYPedido(
            @PathVariable long idRuta,
            @PathVariable long idPedido) {
        return rutaPedidoUseCase.buscarPorRutaYPedido(idRuta, idPedido)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public RutaPedidoResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody RutaPedidoRequestDTO request) {
        return mapper.toResponse(rutaPedidoUseCase.actualizar(mapper.toDomain(id, request)));
    }
}