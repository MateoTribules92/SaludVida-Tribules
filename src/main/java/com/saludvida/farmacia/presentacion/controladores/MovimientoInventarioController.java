package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IMovimientoInventarioUseCase;
import com.saludvida.farmacia.dominio.entidades.TipoMovimiento;
import com.saludvida.farmacia.presentacion.dto.request.MovimientoInventarioRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.MovimientoInventarioResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IMovimientoInventarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimientos-inventario")
public class MovimientoInventarioController {

    private final IMovimientoInventarioUseCase movimientoInventarioUseCase;
    private final IMovimientoInventarioDtoMapper mapper;

    public MovimientoInventarioController(
            IMovimientoInventarioUseCase movimientoInventarioUseCase,
            IMovimientoInventarioDtoMapper mapper) {
        this.movimientoInventarioUseCase = movimientoInventarioUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovimientoInventarioResponseDTO registrar(@Valid @RequestBody MovimientoInventarioRequestDTO request) {
        return mapper.toResponse(movimientoInventarioUseCase.registrar(mapper.toDomain(request)));
    }

    @GetMapping
    public List<MovimientoInventarioResponseDTO> listar() {
        return movimientoInventarioUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventarioResponseDTO> buscarPorId(@PathVariable long id) {
        return movimientoInventarioUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/inventario/{idInventario}")
    public List<MovimientoInventarioResponseDTO> buscarPorInventario(@PathVariable long idInventario) {
        return movimientoInventarioUseCase.buscarPorInventario(idInventario)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<MovimientoInventarioResponseDTO> buscarPorUsuario(@PathVariable long idUsuario) {
        return movimientoInventarioUseCase.buscarPorUsuario(idUsuario)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/tipo/{tipoMovimiento}")
    public List<MovimientoInventarioResponseDTO> buscarPorTipoMovimiento(@PathVariable TipoMovimiento tipoMovimiento) {
        return movimientoInventarioUseCase.buscarPorTipoMovimiento(tipoMovimiento)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
