package com.dvsuperior.hrworker.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvsuperior.hrworker.entities.Worker;
public interface WorkerRepository  extends JpaRepository<Worker, Long>{

	
}
