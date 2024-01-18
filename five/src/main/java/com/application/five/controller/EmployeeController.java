package com.application.five.controller;

import com.application.five.payload.EmployeesLoginDto;
import com.application.five.payload.EmployeesRegisterDto;
import com.application.five.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/login")
    public ResponseEntity<String> employeeLogin(@RequestBody EmployeesLoginDto employeesLoginDto) {

        return new ResponseEntity<>("Login Successfully",HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> employeeRegistration(@RequestBody EmployeesRegisterDto employeesRegisterDto) {
        return  new ResponseEntity<>(employeeService.registerEmployee(employeesRegisterDto),HttpStatus.OK);
    }

}
