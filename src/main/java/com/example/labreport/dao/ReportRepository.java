package com.example.labreport.dao;

import com.example.labreport.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer>
{
    List<Report> findByOrderByDateAsc();
    List<Report> findByOrderByDateDesc();


    @Query("select e from Report e where lower(e.patientName) like lower(concat('%', :param1, '%') )" +
            "or lower(e.patientLastname) like lower(concat('%', :param1, '%'))" +
            "or lower(e.patientId) like lower(:param1)"+
            "or lower(e.worker.workerId) like lower(:param1)"+
            "or lower(e.worker.workerFirstname) like lower(concat('%', :param1, '%') )"+
            "or lower(e.worker.workerLastName) like lower(concat('%', :param1, '%') )")
    List<Report> findByNameOrLastnameOrWorkerName(@Param("param1") String param1);

}
