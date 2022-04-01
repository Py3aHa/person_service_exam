package ru.exam.ruzana.service;

import ru.exam.ruzana.model.Roles;

public interface RolesService extends BasicCRUDService<Roles> {
    Roles findByRoleName(String name);
}
