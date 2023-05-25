package com.atos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.app.entity.Patron;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {

}
