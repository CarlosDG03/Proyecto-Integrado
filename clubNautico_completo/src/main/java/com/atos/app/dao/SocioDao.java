package com.atos.app.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.app.entity.Socio;
import com.atos.app.repository.SocioRepository;

@Service
public class SocioDao implements ISocioDao {

	@Autowired
	SocioRepository sr;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Socio> findAll() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Socio> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return sr.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Socio> findById(Long id) {
		// TODO Auto-generated method stub
		return sr.findById(id);
	}

	@Override
	@Transactional
	public Socio save(Socio socio) {
		// TODO Auto-generated method stub
		return sr.save(socio);
	}

	@Override
	@Transactional
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
	}

}
