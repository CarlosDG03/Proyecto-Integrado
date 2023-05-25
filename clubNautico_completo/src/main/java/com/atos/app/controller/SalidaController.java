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

import com.atos.app.dao.SalidaDao;
import com.atos.app.entity.Salida;

@RestController
@RequestMapping("/api/salidas")
public class SalidaController {

	@Autowired
	private SalidaDao salidaDao;
	
	
	//CREATE
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Salida salida){
		return ResponseEntity.status(HttpStatus.CREATED).body(salidaDao.save(salida));
	}
	
	//READ
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long idSalida){
		Optional<Salida> oSalida = salidaDao.findById(idSalida);
		
		if (!oSalida.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oSalida);
	}
	//READ ALL
	@GetMapping
	public List<Salida> readAll(){
		List<Salida> salidas = StreamSupport.stream(salidaDao.findAll().spliterator(), false).collect(Collectors.toList());
		
		return salidas;
	}
	
	//UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Salida salidaDetails, @PathVariable(value = "id") Long idSalida){
		Optional<Salida> salida = salidaDao.findById(idSalida);
		
		if (!salida.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(salidaDetails, salida.get());
		salida.get().setFechaSalida(salidaDetails.getFechaSalida());
		salida.get().setDestino(salidaDetails.getDestino());
		salida.get().setIdbarco(salidaDetails.getIdbarco());
		salida.get().setIdPatron(salidaDetails.getIdPatron());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salidaDao.save(salida.get()));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long idSalida){
		
		if (!salidaDao.findById(idSalida).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		salidaDao.deletedById(idSalida);
		return ResponseEntity.ok().build();
	}
}
