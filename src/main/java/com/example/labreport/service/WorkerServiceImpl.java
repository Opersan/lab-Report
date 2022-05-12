package com.example.labreport.service;

import com.example.labreport.dao.WorkerRepository;
import com.example.labreport.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService
{
    private WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository)
    {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker findById(int theId) {
        Optional<Worker> result = workerRepository.findById(theId);

        Worker worker = null;

        if (result.isPresent()) worker = result.get();
        else throw new RuntimeException("Did not find report id + " + theId);
        return worker;
    }

    @Override
    public void save(Worker theWorker) {
        workerRepository.save(theWorker);
    }

    @Override
    public void deleteById(int theId) {
        workerRepository.deleteById(theId);
    }
}
