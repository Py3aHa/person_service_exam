package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.exam.ruzana.model.LogEntity;

import java.util.List;


@Mapper
public interface LogEntityRepository {
    void insert(LogEntity logEntity);

    @Select("select * from log_entity")
    List<LogEntity> findAll();
}
