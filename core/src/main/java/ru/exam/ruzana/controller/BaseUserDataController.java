package ru.exam.ruzana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import ru.exam.ruzana.model.PersonDataEntity;
import ru.exam.ruzana.model.Roles;
import ru.exam.ruzana.service.UserService;

import java.util.stream.Collectors;

public class BaseUserDataController {
    @Autowired
    public UserService userService;

    /**
     * Receiving data about an authenticated user by mail.
     * @return person data of authenticated user
     */

    public PersonDataEntity getAuthenticatedUser() {
        PersonDataEntity personData = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User user = (User) auth.getPrincipal();
            personData = userService.findByEmail(user.getUsername());
            personData.setRoles(user.getAuthorities().stream().map(i -> (Roles)i).collect(Collectors.toSet()));
        }
        return personData;
    }
}
