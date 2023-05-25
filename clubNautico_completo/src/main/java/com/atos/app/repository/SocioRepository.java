package com.atos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.app.entity.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

}
