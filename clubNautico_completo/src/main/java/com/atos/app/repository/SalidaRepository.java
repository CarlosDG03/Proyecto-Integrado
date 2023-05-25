package com.atos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.app.entity.Salida;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Long> {

}
