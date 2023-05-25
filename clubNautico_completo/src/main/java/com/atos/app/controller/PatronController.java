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

import com.atos.app.dao.PatronDao;
import com.atos.app.entity.Patron;

@RestController
@RequestMapping("/api/patrones")
public class PatronController {

	@Autowired
	private PatronDao patronDao;
	
	
	//CREATE
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Patron patron){
		return ResponseEntity.status(HttpStatus.CREATED).body(patronDao.save(patron));
	}
	
	//READ
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long idPatron){
		Optional<Patron> oPatron = patronDao.findById(idPatron);
		
		if (!oPatron.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPatron);
	}
	//READ ALL
	@GetMapping
	public List<Patron> readAll(){
		List<Patron> patrones = StreamSupport.stream(patronDao.findAll().spliterator(), false).collect(Collectors.toList());
		
		return patrones;
	}
	
	//UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Patron patronDetails, @PathVariable(value = "id") Long idPatron){
		Optional<Patron> patron = patronDao.findById(idPatron);
		
		if (!patron.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(patronDetails, patron.get());
		patron.get().setNombre(patronDetails.getNombre());
		patron.get().setApellidos(patronDetails.getApellidos());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(patronDao.save(patron.get()));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long idPatron){
		
		if (!patronDao.findById(idPatron).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		patronDao.deletedById(idPatron);
		return ResponseEntity.ok().build();
	}
}
