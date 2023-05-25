package com.atos.app.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atos.app.entity.Salida;

public interface ISalidaDao {

public Iterable<Salida> findAll();
	
	public Page<Salida> findAll(Pageable pageable);
	
	public Optional<Salida> findById(Long id);
	
	public Salida save(Salida salida);
	
	public void deletedById(Long id);
}
