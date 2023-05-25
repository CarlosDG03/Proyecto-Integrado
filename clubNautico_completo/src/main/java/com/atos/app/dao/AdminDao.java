package com.atos.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.app.entity.Admin;
import com.atos.app.repository.AdminRepository;



@Service
public class AdminDao implements IAdminDao {

	@Autowired
	AdminRepository ar;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Admin> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return ar.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Admin> findById(Long id) {
		// TODO Auto-generated method stub
		return ar.findById(id);
	}

	@Override
	@Transactional
	public Admin save(Admin admin) {
		// TODO Auto-generated method stub
		return ar.save(admin);
	}

	@Override
	@Transactional
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		ar.deleteById(id);
	}
}
