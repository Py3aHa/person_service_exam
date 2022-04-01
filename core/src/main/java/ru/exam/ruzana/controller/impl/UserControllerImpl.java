package ru.exam.ruzana.controller.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.exam.ruzana.controller.BaseUserDataController;
import ru.exam.ruzana.controller.UserController;
import ru.exam.ruzana.dto.PersonDataDto;
import ru.exam.ruzana.model.PersonDataEntity;
import ru.exam.ruzana.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserControllerImpl extends BaseUserDataController implements UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @GetMapping(path = "/")
    public PersonDataDto getUserData(){
        PersonDataEntity authUser = getAuthenticatedUser();
        PersonDataDto personDataDto = modelMapper.map(authUser, PersonDataDto.class);
        return personDataDto;
    }

    @Override
    @PutMapping(path = "/")
    public String updateUserData(@RequestBody PersonDataDto personData) {
        PersonDataEntity authUser = getAuthenticatedUser();
        if(personData.getId() == authUser.getId()){
            PersonDataEntity person = modelMapper.map(personData, PersonDataEntity.class);
            userService.update(person);
            return "Data were updated";
        } else{
            return "User not found";
        }

    }

    @Override
    @DeleteMapping(path = "/{id}")
    public String deleteUserData(@PathVariable Long id) {
        PersonDataEntity authUser = getAuthenticatedUser();
        if(id == authUser.getId()){
            userService.delete(id);
            return "User was deleted";
        } else{
            return "User not found";
        }
    }

}
