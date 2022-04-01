package ru.exam.ruzana.service;

import ru.exam.ruzana.model.LogEntity;

import java.util.List;

public interface LogEntityService {
    void add(LogEntity logEntity);

    List<LogEntity> getAll();
}
