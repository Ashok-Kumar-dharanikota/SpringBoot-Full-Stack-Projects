package com.application.five.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class EmployeesRegisterDto {

    private String name;
    private String email;
    private String password;
}
