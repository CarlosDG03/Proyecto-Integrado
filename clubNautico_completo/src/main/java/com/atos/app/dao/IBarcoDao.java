package com.atos.app.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atos.app.entity.Barco;

public interface IBarcoDao {

public Iterable<Barco> findAll();
	
	public Page<Barco> findAll(Pageable pageable);
	
	public Optional<Barco> findById(String matricula);
	
	public Barco save(Barco barco);
	
	public void deletedById(String matricula);
}
