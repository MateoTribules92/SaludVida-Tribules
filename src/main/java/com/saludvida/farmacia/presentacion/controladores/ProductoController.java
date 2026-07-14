package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IProductoUseCase;
import com.saludvida.farmacia.presentacion.dto.request.ProductoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.ProductoResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IProductoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final IProductoUseCase productoUseCase;
    private final IProductoDtoMapper mapper;

    public ProductoController(IProductoUseCase productoUseCase, IProductoDtoMapper mapper) {
        this.productoUseCase = productoUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponseDTO crear(@Valid @RequestBody ProductoRequestDTO request) {
        return mapper.toResponse(productoUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<ProductoResponseDTO> listar() {
        return productoUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable long id) {
        return productoUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ProductoResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody ProductoRequestDTO request) {
        return mapper.toResponse(productoUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activar(@PathVariable long id) {
        productoUseCase.activar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable long id) {
        productoUseCase.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
