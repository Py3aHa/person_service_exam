package ru.exam.ruzana;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import ru.exam.ruzana.model.PersonDataEntity;
import ru.exam.ruzana.model.Roles;
import ru.exam.ruzana.service.impl.RolesServiceImpl;
import ru.exam.ruzana.service.impl.UserServiceImpl;

//import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//@Component
public class Init {
    @Autowired
    private RolesServiceImpl rolesService;

    @Autowired
    private UserServiceImpl userService;

//    @PostConstruct
    public void init() {
        Roles owner = new Roles(null, "ROLE_OWNER");
        Roles admin = new Roles(null, "ROLE_ADMIN");
        Roles user = new Roles(null, "ROLE_USER");

        rolesService.save(owner);
        rolesService.save(admin);
        rolesService.save(user);

        Set<Roles> allAccess = new HashSet<>();
        Set<Roles> adminAccess = new HashSet<>();
        Set<Roles> userAccess = new HashSet<>();

        allAccess.add(owner);
        allAccess.add(admin);
        allAccess.add(user);

        adminAccess.add(admin);
        adminAccess.add(user);

        userAccess.add(user);

        PersonDataEntity person = new PersonDataEntity();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        person.setBirthDt(LocalDate.of(1990, 6, 9));
        person.setAge(32);
        person.setSex('m');
        person.setEmail("ivanov@mail.com");
        person.setPassword("ivanov");
        person.setDisabled(false);

        person.setRoles(allAccess);

        userService.savePerson(person);

        person = new PersonDataEntity();
        person.setFirstName("Eve");
        person.setLastName("Ivanova");
        person.setBirthDt(LocalDate.of(1994, 6, 9));
        person.setAge(28);
        person.setSex('f');
        person.setEmail("ivanova@mail.com");
        person.setPassword("ivanova");
        person.setDisabled(false);

        person.setRoles(adminAccess);

        userService.savePerson(person);

        person = new PersonDataEntity();
        person.setFirstName("Igor");
        person.setLastName("Ivanov");
        person.setBirthDt(LocalDate.of(2019, 7, 29));
        person.setAge(2);
        person.setSex('m');
        person.setEmail("ivanov_i@mail.com");
        person.setPassword("ivanov");
        person.setDisabled(false);

        person.setRoles(userAccess);

        userService.savePerson(person);

    }
}

