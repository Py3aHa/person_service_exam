package ru.exam.ruzana.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.model.UsersRoles;
import ru.exam.ruzana.repository.UsersRolesRepository;
import ru.exam.ruzana.service.UsersRolesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UsersRolesImpl implements UsersRolesService {
    @Autowired
    private UsersRolesRepository usersRolesRepository;

    @Override
    public void save(UsersRoles object) {
        usersRolesRepository.insert(object);
    }

    public void saveAll(Set<UsersRoles> object) {
        usersRolesRepository.insertAll(object);
    }

    @Override
    public UsersRoles findById(Long id) {
        return null;
    }

    @Override
    public List<UsersRoles> findAll() {
        Set<UsersRoles> usersRoles = usersRolesRepository.findAll();
        return new ArrayList<>(usersRoles);
    }

    @Override
    public void update(UsersRoles object) {
        usersRolesRepository.update(object);
    }

    @Override
    public void delete(Long id) {
        usersRolesRepository.delete(id);
    }
}
