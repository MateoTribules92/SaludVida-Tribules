package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IUsuarioUseCase;
import com.saludvida.farmacia.presentacion.dto.request.UsuarioRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.UsuarioResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final IUsuarioUseCase usuarioUseCase;
    private final IUsuarioDtoMapper mapper;

    public UsuarioController(IUsuarioUseCase usuarioUseCase, IUsuarioDtoMapper mapper) {
        this.usuarioUseCase = usuarioUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO crear(@Valid @RequestBody UsuarioRequestDTO request) {
        return mapper.toResponse(usuarioUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable long id) {
        return usuarioUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorCorreo(@PathVariable String correo) {
        return usuarioUseCase.buscarPorCorreo(correo)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody UsuarioRequestDTO request) {
        return mapper.toResponse(usuarioUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activar(@PathVariable long id) {
        usuarioUseCase.activar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable long id) {
        usuarioUseCase.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}