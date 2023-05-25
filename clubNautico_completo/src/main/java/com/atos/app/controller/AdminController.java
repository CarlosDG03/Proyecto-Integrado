package com.atos.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.app.dao.AdminDao;
import com.atos.app.entity.Admin;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	private AdminDao adminDao;
	
	
	//CREATE
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Admin admin){
		return ResponseEntity.status(HttpStatus.CREATED).body(adminDao.save(admin));
	}
	
	//READ
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long idAdmin){
		Optional<Admin> oAdmin = adminDao.findById(idAdmin);
		
		if (!oAdmin.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oAdmin);
	}
	//READ ALL
	@GetMapping
	public List<Admin> readAll(){
		List<Admin> admins = StreamSupport.stream(adminDao.findAll().spliterator(), false).collect(Collectors.toList());
		
		return admins;
	}
	
	//UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Admin adminDetails, @PathVariable(value = "id") Long idAdmin){
		Optional<Admin> admin = adminDao.findById(idAdmin);
		
		if (!admin.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(adminDetails, admin.get());
		admin.get().setCorreo(adminDetails.getCorreo());
		admin.get().setContraseña(adminDetails.getContraseña());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(adminDao.save(admin.get()));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long idAdmin){
		
		if (!adminDao.findById(idAdmin).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		adminDao.deletedById(idAdmin);
		return ResponseEntity.ok().build();
	}
}
