package com.atos.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.app.entity.Salida;
import com.atos.app.repository.SalidaRepository;

@Service
public class SalidaDao implements ISalidaDao {

	@Autowired
	SalidaRepository sr;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Salida> findAll() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Salida> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return sr.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Salida> findById(Long id) {
		// TODO Auto-generated method stub
		return sr.findById(id);
	}

	@Override
	@Transactional
	public Salida save(Salida salida) {
		// TODO Auto-generated method stub
		return sr.save(salida);
	}

	@Override
	@Transactional
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
	}
}
