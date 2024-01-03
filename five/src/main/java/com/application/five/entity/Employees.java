package com.application.five.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
public class Employees {

    private long Id;
    private String name;
    private String role;
    private String department;
}
