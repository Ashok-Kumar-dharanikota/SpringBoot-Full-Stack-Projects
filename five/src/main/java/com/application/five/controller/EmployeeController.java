package com.application.five.controller;

import com.application.five.payload.EmployeesDto;
import com.application.five.payload.EmployeesRegisterDto;
import com.application.five.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<String> employeeRegistration(@RequestBody EmployeesRegisterDto employeesRegisterDto) {
        return  new ResponseEntity<>(employeeService.registerEmployee(employeesRegisterDto),HttpStatus.OK);
    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<EmployeesDto> getEmployeeProfile(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeesDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<EmployeesDto> updateEmployee(@RequestBody EmployeesDto employeesDto, @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeesDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteEmployee(@PathVariable(name = "id") long id) {
        employeeService.deleteEmployee(id);
    }
}
