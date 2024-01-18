package com.application.five.service;

import com.application.five.payload.EmployeesDto;
import com.application.five.payload.EmployeesLoginDto;
import com.application.five.payload.EmployeesRegisterDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public String registerEmployee(EmployeesRegisterDto employeesRegisterDto);


    public EmployeesDto getEmployee(long e_Id);

    public List<EmployeesDto> getAllEmployee();

    public EmployeesDto updateEmployee(long e_Id, EmployeesDto employeesDto);

    public void deleteEmployee(long e_Id);

}
