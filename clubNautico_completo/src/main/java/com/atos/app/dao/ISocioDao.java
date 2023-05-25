package com.atos.app.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atos.app.entity.Socio;

public interface ISocioDao {

	public Iterable<Socio> findAll();
	
	public Page<Socio> findAll(Pageable pageable);
	
	public Optional<Socio> findById(Long id);
	
	public Socio save(Socio socio);
	
	public void deletedById(Long id);
}
