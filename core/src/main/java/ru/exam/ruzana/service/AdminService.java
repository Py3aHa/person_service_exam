package ru.exam.ruzana.service;

import ru.exam.ruzana.dto.PersonPrivateDataDto;

import java.util.List;

public interface AdminService extends BasicCRUDService<PersonPrivateDataDto>{
    List<PersonPrivateDataDto> getAllActivePersons();

    List<PersonPrivateDataDto> getAllDisabledPersons();
}
