package com.atos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.app.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
