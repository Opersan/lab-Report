package com.example.labreport.dao;

import com.example.labreport.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer>
{
}
