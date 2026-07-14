package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.ICategoriaUseCase;
import com.saludvida.farmacia.presentacion.dto.request.CategoriaRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.CategoriaResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.ICategoriaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final ICategoriaUseCase categoriaUseCase;
    private final ICategoriaDtoMapper mapper;

    public CategoriaController(ICategoriaUseCase categoriaUseCase, ICategoriaDtoMapper mapper) {
        this.categoriaUseCase = categoriaUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponseDTO crear(@Valid @RequestBody CategoriaRequestDTO request) {
        return mapper.toResponse(categoriaUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<CategoriaResponseDTO> listar() {
        return categoriaUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable long id) {
        return categoriaUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public CategoriaResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody CategoriaRequestDTO request) {
        return mapper.toResponse(categoriaUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activar(@PathVariable long id) {
        categoriaUseCase.activar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable long id) {
        categoriaUseCase.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
