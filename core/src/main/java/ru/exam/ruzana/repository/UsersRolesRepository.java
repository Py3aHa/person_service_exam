package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import ru.exam.ruzana.model.UsersRoles;

import java.util.Set;

@Mapper
public interface UsersRolesRepository {
    void insert(UsersRoles usersRoles);

    void insertAll(Set<UsersRoles> usersRoles);

    Set<UsersRoles> findAll();

    void update(UsersRoles usersRoles);

    void delete(Long userId);
}
