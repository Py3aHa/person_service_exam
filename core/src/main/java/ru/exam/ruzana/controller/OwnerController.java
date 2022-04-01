package ru.exam.ruzana.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ru.exam.ruzana.dto.PersonPrivateDataDto;

public interface OwnerController {
    /**
     * Only 'owner' can save person data.
     * Note, by default person's password is 'password'
     * @param personPrivateDataDto is instance of PersonPrivateDataDto entity
     */
    void saveUser(PersonPrivateDataDto personPrivateDataDto);

    void updateUser(@RequestBody PersonPrivateDataDto personData);
}
