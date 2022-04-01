package ru.exam.ruzana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogEntity {
    private Long id;

    private LocalDateTime dateTime;

    private String methodName;

    private String className;

    private String userName;

}
