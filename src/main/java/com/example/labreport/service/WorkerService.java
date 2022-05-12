package com.example.labreport.service;

import com.example.labreport.entity.Report;
import com.example.labreport.entity.Worker;

import java.util.List;

public interface WorkerService
{
    List<Worker> findAll();
    Worker findById(int theId);
    void save(Worker theWorker);
    void deleteById(int theId);
}
