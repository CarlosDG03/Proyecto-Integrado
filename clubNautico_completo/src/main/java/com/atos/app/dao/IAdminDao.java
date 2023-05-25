package com.atos.app.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atos.app.entity.Admin;

public interface IAdminDao {

public Iterable<Admin> findAll();
	
	public Page<Admin> findAll(Pageable pageable);
	
	public Optional<Admin> findById(Long id);
	
	public Admin save(Admin admin);
	
	public void deletedById(Long id);
}
