package ru.exam.ruzana.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.exam.ruzana.dto.PersonPrivateDataDto;

import java.util.List;

public interface AdminController {
    /**
     * Searches for all objects without passwords of the database entity.
     *
     * @return entity objects as a list. If there is no object, then an empty list is returned
     */
    List<PersonPrivateDataDto> getAllUsers();

    void deletePersonById(@PathVariable Long id);

    List<PersonPrivateDataDto> getAllActiveUsers();

    List<PersonPrivateDataDto> getAllDisabledUsers();

}
