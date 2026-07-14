package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IClienteUseCase;
import com.saludvida.farmacia.presentacion.dto.request.ClienteRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.ClienteResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IClienteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final IClienteUseCase clienteUseCase;
    private final IClienteDtoMapper mapper;

    public ClienteController(IClienteUseCase clienteUseCase, IClienteDtoMapper mapper) {
        this.clienteUseCase = clienteUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO crear(@Valid @RequestBody ClienteRequestDTO request) {
        return mapper.toResponse(clienteUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return clienteUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable long id) {
        return clienteUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody ClienteRequestDTO request) {
        return mapper.toResponse(clienteUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activar(@PathVariable long id) {
        clienteUseCase.activar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable long id) {
        clienteUseCase.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
