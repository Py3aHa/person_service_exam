package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import ru.exam.ruzana.model.Roles;

import java.util.Set;

@Mapper
public interface RolesRepository {
    void insert(Roles role);

    Set<Roles> getAllByPersonId(Long id);

    void update(Roles role);

    void deleteById(Long id);

    Roles findByRoleName(String role);
}
