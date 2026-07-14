package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IRutaUseCase;
import com.saludvida.farmacia.dominio.entidades.EstadoRuta;
import com.saludvida.farmacia.presentacion.dto.request.RutaRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.RutaResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IRutaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    private final IRutaUseCase rutaUseCase;
    private final IRutaDtoMapper mapper;

    public RutaController(IRutaUseCase rutaUseCase, IRutaDtoMapper mapper) {
        this.rutaUseCase = rutaUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RutaResponseDTO crear(@Valid @RequestBody RutaRequestDTO request) {
        return mapper.toResponse(rutaUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<RutaResponseDTO> listar() {
        return rutaUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaResponseDTO> buscarPorId(@PathVariable long id) {
        return rutaUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public RutaResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody RutaRequestDTO request) {
        return mapper.toResponse(rutaUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable long id, @RequestParam EstadoRuta estado) {
        rutaUseCase.cambiarEstado(id, estado);
        return ResponseEntity.noContent().build();
    }
}
