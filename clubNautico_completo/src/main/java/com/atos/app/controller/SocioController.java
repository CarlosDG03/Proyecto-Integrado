package com.atos.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atos.app.dao.ISocioDao;
import com.atos.app.dao.SocioDao;
import com.atos.app.entity.Socio;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

	@Autowired
	private SocioDao socioDao;
	
	
	//CREATE
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Socio socio){
		return ResponseEntity.status(HttpStatus.CREATED).body(socioDao.save(socio));
	}
	
	//READ
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long idSocio){
		Optional<Socio> oSocio = socioDao.findById(idSocio);
		
		if (!oSocio.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oSocio);
	}
	//READ ALL
	@GetMapping
	public List<Socio> readAll(){
		List<Socio> socios = StreamSupport.stream(socioDao.findAll().spliterator(), false).collect(Collectors.toList());
		
		return socios;
	}
	
	//UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Socio socioDetails, @PathVariable(value = "id") Long idSocio){
		Optional<Socio> socio = socioDao.findById(idSocio);
		
		if (!socio.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(socioDetails, socio.get());
		socio.get().setNombre(socioDetails.getNombre());
		socio.get().setApellidos(socioDetails.getApellidos());
		socio.get().setNum_barcos(socioDetails.getNum_barcos());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(socioDao.save(socio.get()));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long idSocio){
		
		if (!socioDao.findById(idSocio).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		socioDao.deletedById(idSocio);
		return ResponseEntity.ok().build();
	}
	
}
