package ru.exam.ruzana.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.model.PersonDataEntity;
import ru.exam.ruzana.model.Roles;
import ru.exam.ruzana.model.UsersRoles;
import ru.exam.ruzana.repository.PersonDataRepository;
import ru.exam.ruzana.repository.RolesRepository;
import ru.exam.ruzana.service.RolesService;
import ru.exam.ruzana.service.UserService;
import ru.exam.ruzana.service.UsersRolesService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@EnableWebSecurity
public class UserServiceImpl implements UserService {
    @Autowired
    PersonDataRepository personDataRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsersRolesService usersRolesService;

    @Autowired
    private RolesService rolesService;

    @Override
    public PersonDataEntity findByEmail(String email) {
        return personDataRepository.findByEmail(email);
    }

    @Override
    public PersonDataEntity findById(Long id) {
        return personDataRepository.findById(id);
    }

    @Override
    public void update(PersonDataEntity personData) {
        personDataRepository.update(personData);
    }

    @Override
    public void delete(Long id) {
        personDataRepository.deleteById(id);
    }

    @Override
    public void savePerson(PersonDataEntity personData) {
        String password = personData.getPassword();
        personData.setPassword(bCryptPasswordEncoder.encode(password));
        personDataRepository.insert(personData);

        personData = findByEmail(personData.getEmail());
        Roles role = rolesService.findByRoleName("ROLE_USER");
        UsersRoles usersRoles = new UsersRoles(personData.getId(), role.getId());
        usersRolesService.save(usersRoles);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PersonDataEntity personData = findByEmail(email);
        if (personData == null) {
            return null;
        } else {
            Set<Roles> roles = rolesRepository.getAllByPersonId(personData.getId());
            User user = new User(personData.getEmail(), personData.getPassword(), roles);
            List<Roles> cur = user.getAuthorities().stream().map(i -> (Roles) i).collect(Collectors.toList());
            return user;
        }
    }
}
