package ru.exam.ruzana.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.dto.PersonPrivateDataDto;
import ru.exam.ruzana.model.PersonDataEntity;
import ru.exam.ruzana.repository.AdminDataRepository;
import ru.exam.ruzana.service.AdminService;
import ru.exam.ruzana.service.UserService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    protected AdminDataRepository adminDataRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @Override
    public void save(PersonPrivateDataDto object) {
        PersonDataEntity personDataEntity = modelMapper.map(object, PersonDataEntity.class);
        personDataEntity.setPassword(bCryptPasswordEncoder.encode("password"));
        userService.savePerson(personDataEntity);
    }

    @Override
    public PersonPrivateDataDto findById(Long id) {
        return adminDataRepository.findById(id);
    }

    @Override
    public List<PersonPrivateDataDto> findAll() {
        return adminDataRepository.findAll();
    }

    @Override
    public void update(PersonPrivateDataDto object) {
        ModelMapper modelMapper = new ModelMapper();
        PersonDataEntity personDataEntity = modelMapper.map(object, PersonDataEntity.class);
        adminDataRepository.update(personDataEntity);
    }

    @Override
    public void delete(Long id) {
        adminDataRepository.deleteById(id);
    }

    @Override
    public List<PersonPrivateDataDto> getAllActivePersons() {
        return adminDataRepository.findAllByDisabledIsFalse();
    }

    @Override
    public List<PersonPrivateDataDto> getAllDisabledPersons() {
        return adminDataRepository.findAllByDisabledIsTrue();
    }
}
