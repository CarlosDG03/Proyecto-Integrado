package com.atos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.app.entity.Barco;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, String> {

}
