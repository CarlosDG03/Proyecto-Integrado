package com.atos.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.app.entity.Patron;
import com.atos.app.repository.PatronRepository;

@Service
public class PatronDao implements IPatronDao {

	@Autowired
	PatronRepository pr;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Patron> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Patron> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return pr.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Patron> findById(Long id) {
		// TODO Auto-generated method stub
		return pr.findById(id);
	}

	@Override
	@Transactional
	public Patron save(Patron patron) {
		// TODO Auto-generated method stub
		return pr.save(patron);
	}

	@Override
	@Transactional
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}
}
