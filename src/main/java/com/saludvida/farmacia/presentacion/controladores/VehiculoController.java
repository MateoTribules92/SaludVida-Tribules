package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IVehiculoUseCase;
import com.saludvida.farmacia.presentacion.dto.request.VehiculoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.VehiculoResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IVehiculoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final IVehiculoUseCase vehiculoUseCase;
    private final IVehiculoDtoMapper mapper;

    public VehiculoController(IVehiculoUseCase vehiculoUseCase, IVehiculoDtoMapper mapper) {
        this.vehiculoUseCase = vehiculoUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehiculoResponseDTO crear(@Valid @RequestBody VehiculoRequestDTO request) {
        return mapper.toResponse(vehiculoUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<VehiculoResponseDTO> listar() {
        return vehiculoUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoResponseDTO> buscarPorId(@PathVariable long id) {
        return vehiculoUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public VehiculoResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody VehiculoRequestDTO request) {
        return mapper.toResponse(vehiculoUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activar(@PathVariable long id) {
        vehiculoUseCase.activar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable long id) {
        vehiculoUseCase.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
