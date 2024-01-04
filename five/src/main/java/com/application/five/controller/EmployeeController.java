package com.application.five.controller;

import com.application.five.entity.Employees;
import com.application.five.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeesRepository employeesRepository;

    public ResponseEntity<List<Employees>> getAllEmployees() {

        return new ResponseEntity<>(employeesRepository.findAll(), HttpStatus.OK);
    }

}
