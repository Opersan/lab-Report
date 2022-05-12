package com.example.labreport.service;

import com.example.labreport.dao.ReportRepository;
import com.example.labreport.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService{

    private ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> orderByAsc()
    {
        return reportRepository.findByOrderByDateAsc();
    }
    @Override
    public List<Report> orderByDesc()
    {
        return reportRepository.findByOrderByDateDesc();
    }


    @Override
    public Report findById(int theId) {
        Optional<Report> result = reportRepository.findById(theId);

        Report report = null;

        if (result.isPresent()) report = result.get();
        else throw new RuntimeException("Did not find report id: " + theId);
        return report;
    }

    @Override
    public Report save(Report theReport){
        return reportRepository.save(theReport);
    }

    @Override
    public void deleteById(int theId) {
        reportRepository.deleteById(theId);
    }

    @Override
    public List<Report> searchBy(String param) {
        List<Report> results = null;

        if (param != null && (param.trim().length() > 0))
        {
            results = reportRepository.findByNameOrLastnameOrWorkerName(param);
        }
        else if (param.trim().length() == 0)
        {
            results = reportRepository.findAll();
        }
        return results;
    }

}
