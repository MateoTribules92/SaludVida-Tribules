package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IProveedorUseCase;
import com.saludvida.farmacia.presentacion.dto.request.ProveedorRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.ProveedorResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IProveedorDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final IProveedorUseCase proveedorUseCase;
    private final IProveedorDtoMapper mapper;

    public ProveedorController(IProveedorUseCase proveedorUseCase, IProveedorDtoMapper mapper) {
        this.proveedorUseCase = proveedorUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProveedorResponseDTO crear(@Valid @RequestBody ProveedorRequestDTO request) {
        return mapper.toResponse(proveedorUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<ProveedorResponseDTO> listar() {
        return proveedorUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> buscarPorId(@PathVariable long id) {
        return proveedorUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ProveedorResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody ProveedorRequestDTO request) {
        return mapper.toResponse(proveedorUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activar(@PathVariable long id) {
        proveedorUseCase.activar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable long id) {
        proveedorUseCase.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}