package com.example.management.moudle;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    private Integer userId;
    private String username;
    private String dateOfBirth;
    private String  email;
    private String phoneNo;
    private LocalDate date;
    private LocalTime time;
}
