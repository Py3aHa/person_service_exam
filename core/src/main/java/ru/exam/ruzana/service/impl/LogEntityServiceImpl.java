package ru.exam.ruzana.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.model.LogEntity;
import ru.exam.ruzana.repository.LogEntityRepository;
import ru.exam.ruzana.service.LogEntityService;

import java.util.List;

@Service
public class LogEntityServiceImpl implements LogEntityService {
    @Autowired
    private LogEntityRepository logEntityRepository;

    @Override
    public void add(LogEntity logEntity) {
        logEntityRepository.insert(logEntity);
    }

    @Override
    public List<LogEntity> getAll() {
        return logEntityRepository.findAll();
    }
}
