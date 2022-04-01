package ru.exam.ruzana.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.model.Roles;
import ru.exam.ruzana.repository.RolesRepository;
import ru.exam.ruzana.service.RolesService;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public void save(Roles role) {
        rolesRepository.insert(role);
    }

    @Override
    public Roles findById(Long id) {
        return null;
    }

    @Override
    public List<Roles> findAll() {
        return null;
    }

    @Override
    public void update(Roles object) {
        rolesRepository.update(object);
    }

    @Override
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public Roles findByRoleName(String name) {
        return rolesRepository.findByRoleName(name);
    }
}
