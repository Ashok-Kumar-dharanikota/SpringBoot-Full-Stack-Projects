package com.application.five.serviceimpl;

import com.application.five.Exception.EmployeeNotFoundException;
import com.application.five.entity.Employees;
import com.application.five.payload.EmployeesDto;
import com.application.five.payload.EmployeesRegisterDto;
import com.application.five.repository.EmployeesRepository;
import com.application.five.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String registerEmployee(EmployeesRegisterDto employeesRegisterDto) {
        Employees savedEmployee = DtoToEntity(employeesRegisterDto);
        employeesRepository.save(savedEmployee);
        return String.format("Welcome! %s Your successfully registered",employeesRegisterDto.getName());
    }


    @Override
    public EmployeesDto getEmployee(long e_Id) {
        Employees employees = employeesRepository.findById(e_Id).orElseThrow(
                () -> new EmployeeNotFoundException(String.format("User Id %d not Found", e_Id)
        ));
        return EntityToDto(employees);
    }

    @Override
    public List<EmployeesDto> getAllEmployee() {

        List<Employees> AllEmpl = employeesRepository.findAll();

        return AllEmpl.stream().map(
                employees -> modelMapper.map(employees,EmployeesDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeesDto updateEmployee(long e_Id, EmployeesDto employeesDto) {
        Employees employees = employeesRepository.findById(e_Id).orElseThrow(
                () -> new EmployeeNotFoundException(String.format("User Id %d not Found", e_Id)
                ));
        employeesRepository.save(employees);
        return employeesDto;
    }

    @Override
    public void deleteEmployee(long e_Id) {
        Employees employees = employeesRepository.findById(e_Id).orElseThrow(
                () -> new EmployeeNotFoundException(String.format("User Id %d not Found", e_Id)
                ));
        employeesRepository.deleteById(e_Id);
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
