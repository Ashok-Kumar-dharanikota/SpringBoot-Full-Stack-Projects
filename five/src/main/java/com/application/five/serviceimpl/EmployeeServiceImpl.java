package com.application.five.serviceimpl;

import com.application.five.Exception.EmployeeAlreadyExcistException;
import com.application.five.Exception.EmployeeNotFoundException;
import com.application.five.entity.Employees;
import com.application.five.payload.EmployeesDto;
import com.application.five.payload.EmployeesLoginDto;
import com.application.five.payload.EmployeesRegisterDto;
import com.application.five.repository.EmployeesRepository;
import com.application.five.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;


    @Override
    public String registerEmployee(EmployeesRegisterDto employeesRegisterDto) {
        Employees employee = employeesRepository.findByEmail(employeesRegisterDto.getEmail()).orElseThrow(
                () -> new EmployeeAlreadyExcistException("Employee with this email is already Exsist")
        );
        Employees savedEmployee = DtoToEntity(employeesRegisterDto);
        employeesRepository.save(savedEmployee);

        return String.format("Welcome! %s Your successfully registered",employeesRegisterDto.getName());
    }

    @Override
    public String loginEmployee(EmployeesLoginDto employeesLoginDto) {
        Employees employee = employeesRepository.findByEmail(employeesLoginDto.getEmail()).orElseThrow(
                () -> new EmployeeNotFoundException("Employee with this email is not Exsist")
        );
        if(Objects.equals(employee.getEmail(), employeesLoginDto.getEmail()) && Objects.equals(employee.getPassword(), employeesLoginDto.getPassword())) {

        }

    }

    @Override
    public EmployeesDto getEmployee(long e_Id) {
        return null;
    }

    @Override
    public List<EmployeesDto> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeesDto updateEmployee(long e_Id) {
        return null;
    }

    @Override
    public void deleteEmployee(long e_Id) {

    }

    private Employees DtoToEntity(EmployeesRegisterDto employeesRegisterDto) {
        Employees employees = new Employees();
        employees.setName(employeesRegisterDto.getName());
        employees.setEmail(employeesRegisterDto.getEmail());
        employees.setPassword(employeesRegisterDto.getPassword());
        return employees;
    }

    private EmployeesDto EntityToDto(Employees employees) {
        EmployeesDto employeesDto = new EmployeesDto();
        employeesDto.setName(employees.getName());
        employeesDto.setDepartment(employees.getDepartment());
        employeesDto.setRole(employees.getRole());
        return employeesDto;
    }
}
