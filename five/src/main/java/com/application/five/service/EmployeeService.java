package com.application.five.service;

import com.application.five.payload.EmployeesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public EmployeesDto addEmployee(EmployeesDto employeesDto);

    public EmployeesDto getEmployee(long e_Id);

    public List<EmployeesDto> getAllEmployee();

    public EmployeesDto updateEmployee(long e_Id);

    public void deleteEmployee(long e_Id);

}
