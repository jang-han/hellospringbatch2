package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.MedicalReport;

@Mapper
public interface MedicalReportMapper {
    List<MedicalReport> selectAllMedicalReports();
}