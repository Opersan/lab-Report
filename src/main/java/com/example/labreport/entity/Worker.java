package com.example.labreport.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "worker")
public class Worker
{
    @Id
    @Column(name = "worker_id")
    @Min(value = 1000000, message = "ID must be 7 digits - it is less than 7")
    @Max(value = 9999999, message = "ID must be 7 digits - it is more than 7")
    @NotNull(message = "ID must be 7 digits")
    private Integer workerId;

    @Column(name = "worker_firstname")
    @NotBlank(message = "Please enter a valid first name")
    private String workerFirstname;

    @Column(name = "worker_lastname")
    @NotBlank(message = "Please enter a valid last name")
    private String workerLastName;

    @OneToMany(mappedBy = "worker")
    private List<Report> reports;

    public Worker() {
    }

    public Worker(Integer workerId, String workerFirstname, String workerLastName, List<Report> reports) {
        this.workerId = workerId;
        this.workerFirstname = workerFirstname;
        this.workerLastName = workerLastName;
        this.reports = reports;
    }

    public Worker(String workerFirstname, String workerLastName, List<Report> reports) {
        this.workerFirstname = workerFirstname;
        this.workerLastName = workerLastName;
        this.reports = reports;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerFirstname() {
        return workerFirstname;
    }

    public void setWorkerFirstname(String workerFirstname) {
        this.workerFirstname = workerFirstname;
    }

    public String getWorkerLastName() {
        return workerLastName;
    }

    public void setWorkerLastName(String workerLastName) {
        this.workerLastName = workerLastName;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId=" + workerId +
                ", workerName='" + workerFirstname + '\'' +
                ", workerLastName='" + workerLastName + '\'' +
                '}';
    }
}
