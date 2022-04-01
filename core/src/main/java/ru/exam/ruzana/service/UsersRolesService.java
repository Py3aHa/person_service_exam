package ru.exam.ruzana.service;

import ru.exam.ruzana.model.UsersRoles;

import java.util.Set;

public interface UsersRolesService extends BasicCRUDService<UsersRoles>{
    void saveAll(Set<UsersRoles> object);
}
