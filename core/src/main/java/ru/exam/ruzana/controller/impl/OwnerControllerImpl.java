package ru.exam.ruzana.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.exam.ruzana.controller.OwnerController;
import ru.exam.ruzana.dto.PersonPrivateDataDto;
import ru.exam.ruzana.service.AdminService;

@RestController
@RequestMapping(path = "/api/owner")
public class OwnerControllerImpl implements OwnerController {
    @Autowired
    private AdminService adminService;

    @Override
    @PostMapping(path = "/")
    public void saveUser(@RequestBody PersonPrivateDataDto personPrivateDataDto) {
        adminService.save(personPrivateDataDto);
    }

    @Override
    @PatchMapping(path = "/")
    public void updateUser(@RequestBody PersonPrivateDataDto personData) {
        adminService.update(personData);
    }

}
