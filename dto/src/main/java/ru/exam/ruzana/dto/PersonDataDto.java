package ru.exam.ruzana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDataDto {
    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    private boolean disabled;

    private LocalDate birthDt;

    private int age;

    private char sex;
}
