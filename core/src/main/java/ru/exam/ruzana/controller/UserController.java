package ru.exam.ruzana.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ru.exam.ruzana.dto.PersonDataDto;

public interface UserController {
    PersonDataDto getUserData();

    String updateUserData(@RequestBody PersonDataDto personData);

    String deleteUserData(Long id);
}
