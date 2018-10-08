package com.alanvieceli.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alanvieceli.api.entities.Empresa;
import com.alanvieceli.api.repository.EmpresaRepository;

@SpringBootApplication
public class TesteJpaApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Kazale IT");
			empresa.setCnpj("74645215000104");
			
			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			
			Optional<Empresa> empresaDb = empresaRepository.findById(1L);
			System.out.println("Empresa por ID: " + empresaDb);
			
			empresaDb.get().setRazaoSocial("Kazale IT Web");			
			this.empresaRepository.save(empresaDb.get());

			Empresa empresaCnpj = empresaRepository.findByCnpj("74645215000104");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);
			
			this.empresaRepository.deleteById(1L);;
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());
			
			
		};
		
	}
}
