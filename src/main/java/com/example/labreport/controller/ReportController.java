package com.example.labreport.controller;

import com.example.labreport.entity.Report;
import com.example.labreport.entity.Worker;
import com.example.labreport.service.ReportService;
import com.example.labreport.service.WorkerService;
import org.hibernate.hql.internal.ast.tree.BinaryLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.table.TableRowSorter;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/reports")
public class ReportController
{
    private ReportService reportService;
    private WorkerService workerService;
    private boolean sortDirFlag = true;

    @Autowired
    public ReportController(ReportService theReportService, WorkerService theWorkerService)
    {
        reportService = theReportService;
        workerService = theWorkerService;
    }

    @GetMapping("/list")
    public String listReports(Model theModel)
    {
        List<Report> reports = reportService.findAll();

        theModel.addAttribute("reports", reports);

        return "list-reports";
    }
    @GetMapping("/order")
    public String orderReportsByDate(Model theModel)
    {
        List<Report> reports;
        if(sortDirFlag)
        {
            reports = reportService.orderByAsc();
            sortDirFlag = false;
        }
        else
        {
            reports = reportService.orderByDesc();
            sortDirFlag = true;
        }

        theModel.addAttribute("reports", reports);
        return "list-reports";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Report report = new Report();
        List<Worker> workers = workerService.findAll();

        theModel.addAttribute("report", report);
        theModel.addAttribute("workers", workers);

        return "form-reports";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("reportId") int theId, Model theModel)
    {
        Report report = reportService.findById(theId);
        List<Worker> workers = workerService.findAll();

        theModel.addAttribute("report", report);
        theModel.addAttribute("workers", workers);

        return "form-reports";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("report") Report report, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("workers", workerService.findAll());
        if (bindingResult.hasErrors()) return "form-reports";
        reportService.save(report);
        return "redirect:/reports/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("reportId") int reportId)
    {
        Report report = reportService.findById(reportId);

        if (report == null) throw new RuntimeException("Report id not found - " + reportId);

        reportService.deleteById(reportId);

        return "redirect:/reports/list";
    }
    @GetMapping("/download")
    public ResponseEntity<?> download(@RequestParam("reportId") int reportId)
    {
        Report report = reportService.findById(reportId);
        return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + report.getPatientName() + "\"." + report.getFileExt())
                    .body(new ByteArrayResource(report.getReportImg()));
    }
    @GetMapping("/search")
    public String delete(@RequestParam("reportParam") String param, Model theModel)
    {
        List<Report> reports = reportService.searchBy(param);

        theModel.addAttribute("reports", reports);

        return "list-reports";
    }

    @GetMapping("/showFormForAddWorker")
    public String showFormForAddWorker(Model theModel)
    {
        Worker worker = new Worker();

        theModel.addAttribute("worker", worker);

        return "form-workers";
    }
    @PostMapping("/saveWorker")
    public String saveWorker(@Valid @ModelAttribute("worker") Worker worker, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "form-workers";
        workerService.save(worker);

        return "redirect:/reports/list";
    }


}
