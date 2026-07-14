package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saludvida.farmacia.dominio.entidades.Categoria;
import com.saludvida.farmacia.dominio.repositorio.ICategoriaRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.ICategoriaJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.ICategoriaJpaRepository;

@Repository
public final class CategoriaRepositorioImpl
        implements ICategoriaRepositorio {

    private final ICategoriaJpaRepository jpaRepository;
    private final ICategoriaJpaMapper mapper;

    public CategoriaRepositorioImpl(
            ICategoriaJpaRepository jpaRepository,
            ICategoriaJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(categoria)));
    }

    @Override
    public Optional<Categoria> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public List<Categoria> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Categoria> listarActivos() {
        return jpaRepository.findAllByActivoTrue().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void cambiarEstadoActivo(long id, boolean activo) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Categoría no encontrada"));

        entity.setActivo(activo);
        jpaRepository.save(entity);
    }

	@Override
	public Optional<Categoria> buscarPorNombre(String nombre) {
	    return jpaRepository.findByNombre(nombre)
	            .map(mapper::toDomain);
	}
}
