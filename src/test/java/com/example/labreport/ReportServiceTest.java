package com.example.labreport;

import com.example.labreport.entity.Report;
import com.example.labreport.entity.Worker;
import com.example.labreport.service.ReportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest
{
    @Mock
    private ReportServiceImpl reportService;

    private Report report1;



    @BeforeEach
    void setup()
    {
        report1 = new Report(5, "asd", "asd", 15151515155L, "kolu", "asd",
                Date.valueOf("2015-05-02"), null, "", new Worker(2, "asd", "asda", null));
    }

    @Test
    void findByIdThrowsExceptionTest()
    {
        when(reportService.findById(2)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> {reportService.findById(2);});
    }

    @Test
    void findByIdTest()
    {
        when(reportService.findById(5)).thenReturn(report1);
        assertSame(report1, reportService.findById(5));
    }

    @Test
    void searchBy()
    {
        when(reportService.searchBy("ismail")).thenReturn(null);
        when(reportService.searchBy("furkan")).thenReturn(new ArrayList<Report>(){{add(report1);}});

        List<Report> reports = new ArrayList<>();
        reports.add(report1);

        assertNull(reportService.searchBy("ismail"));
        assertEquals(reports,reportService.searchBy("furkan"));
    }



}
