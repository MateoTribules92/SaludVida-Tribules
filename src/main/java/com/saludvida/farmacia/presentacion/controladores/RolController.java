package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IRolUseCase;
import com.saludvida.farmacia.presentacion.dto.request.RolRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.RolResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IRolDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final IRolUseCase rolUseCase;
    private final IRolDtoMapper mapper;

    public RolController(IRolUseCase rolUseCase, IRolDtoMapper mapper) {
        this.rolUseCase = rolUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RolResponseDTO crear(@Valid @RequestBody RolRequestDTO request) {
        return mapper.toResponse(rolUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<RolResponseDTO> listar() {
        return rolUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDTO> buscarPorId(@PathVariable long id) {
        return rolUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public RolResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody RolRequestDTO request) {
        return mapper.toResponse(rolUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activar(@PathVariable long id) {
        rolUseCase.activar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable long id) {
        rolUseCase.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}