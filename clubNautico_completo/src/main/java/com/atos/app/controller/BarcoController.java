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

import com.atos.app.dao.BarcoDao;
import com.atos.app.entity.Barco;


@RestController
@RequestMapping("/api/barcos")
public class BarcoController {

	@Autowired
	private BarcoDao barcoDao;
	
	
	//CREATE
		@PostMapping
		public ResponseEntity<?> create (@RequestBody Barco barco){
			return ResponseEntity.status(HttpStatus.CREATED).body(barcoDao.save(barco));
		}
		
		//READ
		@GetMapping("/{id}")
		public ResponseEntity<?> read (@PathVariable(value = "id") String matricula){
			Optional<Barco> oBarco = barcoDao.findById(matricula);
			
			if (!oBarco.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(oBarco);
		}
		//READ ALL
		@GetMapping
		public List<Barco> readAll(){
			List<Barco> barcos = StreamSupport.stream(barcoDao.findAll().spliterator(), false).collect(Collectors.toList());
			
			return barcos;
		}
		
		//UPDATE
		@PutMapping("/{id}")
		public ResponseEntity<?> update (@RequestBody Barco barcoDetails, @PathVariable(value = "id") String matricula){
			Optional<Barco> barco = barcoDao.findById(matricula);
			
			if (!barco.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			BeanUtils.copyProperties(barcoDetails, barco.get());
			barco.get().setNumAmarre(barcoDetails.getNumAmarre());
			barco.get().setCuota(barcoDetails.getCuota());
			barco.get().setIdsocio(barcoDetails.getIdsocio());
			barco.get().setNum_salidas(barcoDetails.getNum_salidas());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(barcoDao.save(barco.get()));
		}
		
		//DELETE
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete (@PathVariable(value = "id") String matricula){
			
			if (!barcoDao.findById(matricula).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			barcoDao.deletedById(matricula);
			return ResponseEntity.ok().build();
		}
}
