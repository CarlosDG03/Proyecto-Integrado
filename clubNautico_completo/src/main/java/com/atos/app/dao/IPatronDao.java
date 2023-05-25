package com.atos.app.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atos.app.entity.Patron;

public interface IPatronDao {

public Iterable<Patron> findAll();
	
	public Page<Patron> findAll(Pageable pageable);
	
	public Optional<Patron> findById(Long id);
	
	public Patron save(Patron patron);
	
	public void deletedById(Long id);
}
