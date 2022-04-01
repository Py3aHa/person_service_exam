package ru.exam.ruzana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDataEntity {
    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    private String password;

    private boolean disabled;

    private Set<Roles> roles;

    private LocalDate birthDt;

    private int age;

    private char sex;
}
