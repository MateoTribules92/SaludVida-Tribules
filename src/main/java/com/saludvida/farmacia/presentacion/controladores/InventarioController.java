package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IInventarioUseCase;
import com.saludvida.farmacia.presentacion.dto.request.InventarioRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.InventarioResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IInventarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {

    private final IInventarioUseCase inventarioUseCase;
    private final IInventarioDtoMapper mapper;

    public InventarioController(IInventarioUseCase inventarioUseCase, IInventarioDtoMapper mapper) {
        this.inventarioUseCase = inventarioUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioResponseDTO guardar(@Valid @RequestBody InventarioRequestDTO request) {
        return mapper.toResponse(inventarioUseCase.guardar(mapper.toDomain(request)));
    }

    @GetMapping
    public List<InventarioResponseDTO> listar() {
        return inventarioUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioResponseDTO> buscarPorId(@PathVariable long id) {
        return inventarioUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}