package com.alanvieceli.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alanvieceli.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Empresa findByCnpj(String cnpj);

}
