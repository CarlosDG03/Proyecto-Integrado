package com.atos.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.app.entity.Barco;
import com.atos.app.repository.BarcoRepository;

@Service
public class BarcoDao implements IBarcoDao {

	@Autowired
	BarcoRepository br;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Barco> findAll() {
		// TODO Auto-generated method stub
		return br.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Barco> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return br.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Barco> findById(String matricula) {
		// TODO Auto-generated method stub
		return br.findById(matricula);
	}

	@Override
	@Transactional
	public Barco save(Barco barco) {
		// TODO Auto-generated method stub
		return br.save(barco);
	}

	@Override
	@Transactional
	public void deletedById(String matricula) {
		// TODO Auto-generated method stub
		br.deleteById(matricula);
	}
}
