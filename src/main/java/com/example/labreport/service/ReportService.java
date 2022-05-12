package com.example.labreport.service;

import com.example.labreport.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReportService
{
    List<Report> findAll();
    Report findById(int theId);
    Report save(Report theReport);
    void deleteById(int theId);
    List<Report> searchBy(String param);
    List<Report> orderByAsc();
    List<Report> orderByDesc();
}
