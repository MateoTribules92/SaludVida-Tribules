package com.saludvida.farmacia.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IFarmaciaUseCase;
import com.saludvida.farmacia.presentacion.dto.request.FarmaciaRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.FarmaciaResponseDTO;
import com.saludvida.farmacia.presentacion.mapeadores.IFarmaciaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/farmacias")
public class FarmaciaController {

    private final IFarmaciaUseCase farmaciaUseCase;
    private final IFarmaciaDtoMapper mapper;

    public FarmaciaController(IFarmaciaUseCase farmaciaUseCase, IFarmaciaDtoMapper mapper) {
        this.farmaciaUseCase = farmaciaUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FarmaciaResponseDTO crear(@Valid @RequestBody FarmaciaRequestDTO request) {
        return mapper.toResponse(farmaciaUseCase.crear(mapper.toDomain(request)));
    }

    @GetMapping
    public List<FarmaciaResponseDTO> listar() {
        return farmaciaUseCase.listarTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmaciaResponseDTO> buscarPorId(@PathVariable long id) {
        return farmaciaUseCase.buscarPorId(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<FarmaciaResponseDTO> buscarPorCiudad(@PathVariable String ciudad) {
        return farmaciaUseCase.buscarPorCiudad(ciudad)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/zona/{zona}")
    public List<FarmaciaResponseDTO> buscarPorZona(@PathVariable String zona) {
        return farmaciaUseCase.buscarPorZona(zona)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    public FarmaciaResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody FarmaciaRequestDTO request) {
        return mapper.toResponse(farmaciaUseCase.actualizar(mapper.toDomain(id, request)));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activar(@PathVariable long id) {
        farmaciaUseCase.activar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable long id) {
        farmaciaUseCase.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}