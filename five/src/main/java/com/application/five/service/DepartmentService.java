package com.application.five.service;

import com.application.five.payload.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    public DepartmentDto createDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartment(long dept_Id);

    public List<DepartmentDto> getAllDepartments();

    public DepartmentDto updateDepartment(long dept_Id);

    public void deleteDepartment(long dept_Id);

}
