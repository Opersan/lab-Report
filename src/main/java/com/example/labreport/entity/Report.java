package com.example.labreport.entity;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int fileId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_lastname")
    private String patientLastname;

    @Column(name = "patient_id")
    @Min(value = 10000000000L, message = "ID must be 11 digits - it is less than 11")
    @Max(value = 99999999999L, message = "ID must be 11 digits - it is more than 11")
    private Long patientId;

    @Column(name = "patient_diagnosis")
    private String patientDiagnosis;

    @Column(name = "diagnosis_detail")
    private String diagDetail;

    @Column(name = "date")
    private Date date = new Date(new java.util.Date().getTime());

    @Lob
    @Column(name = "report_img", columnDefinition = "BLOB")
    private byte[] reportImg;

    @Column(name = "file_ext")
    private String fileExt;

    @ManyToOne()
    @JoinColumn(name = "worker_id", nullable = false)
    @NotNull(message = "You must select a worker")
    private Worker worker;

    public Report() {
    }

    public Report(int fileId, String patientName, String patientLastname, Long patientId, String patientDiagnosis, String diagDetail, Date date, byte[] reportImg, String fileExt, Worker worker) {
        this.fileId = fileId;
        this.patientName = patientName;
        this.patientLastname = patientLastname;
        this.patientId = patientId;
        this.patientDiagnosis = patientDiagnosis;
        this.diagDetail = diagDetail;
        this.date = date;
        this.reportImg = reportImg;
        this.fileExt = fileExt;
        this.worker = worker;
    }

    public Report(String patientName, String patientLastname, Long patientId, String patientDiagnosis, String diagDetail, Date date, byte[] reportImg, String fileExt, Worker worker) {
        this.patientName = patientName;
        this.patientLastname = patientLastname;
        this.patientId = patientId;
        this.patientDiagnosis = patientDiagnosis;
        this.diagDetail = diagDetail;
        this.date = date;
        this.reportImg = reportImg;
        this.fileExt = fileExt;
        this.worker = worker;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLastname() {
        return patientLastname;
    }

    public void setPatientLastname(String patientSurname) {
        this.patientLastname = patientSurname;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public void setPatientDiagnosis(String patientDiagnosis) {
        this.patientDiagnosis = patientDiagnosis;
    }

    public String getDiagDetail() {
        return diagDetail;
    }

    public void setDiagDetail(String diagDetail) {
        this.diagDetail = diagDetail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getReportImg() {
        return reportImg;
    }

    public void setReportImg(MultipartFile file) throws IOException {
        fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
        this.reportImg = file.getBytes();
    }

    public String getFileExt() {
        return fileExt;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Report{" +
                "fileId=" + fileId +
                ", patientName='" + patientName + '\'' +
                ", patientLastname='" + patientLastname + '\'' +
                ", patientId=" + patientId +
                ", patientDiagnosis='" + patientDiagnosis + '\'' +
                ", diagDetail='" + diagDetail + '\'' +
                ", date=" + date +
                ", reportImg=" + Arrays.toString(reportImg) +
                ", fileExt='" + fileExt + '\'' +
                ", worker=" + worker +
                '}';
    }
}
