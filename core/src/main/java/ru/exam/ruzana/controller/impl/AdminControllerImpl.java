package ru.exam.ruzana.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.exam.ruzana.controller.AdminController;
import ru.exam.ruzana.controller.BaseUserDataController;
import ru.exam.ruzana.dto.PersonPrivateDataDto;
import ru.exam.ruzana.service.AdminService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/admin/users")
public class AdminControllerImpl extends BaseUserDataController implements AdminController {
    @Autowired
    protected AdminService adminService;

    @Override
    @GetMapping(path = "/")
    public List<PersonPrivateDataDto> getAllUsers() {
        return adminService.findAll();
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public void deletePersonById(@PathVariable Long id) {
        adminService.delete(id);
    }

    @Override
    @GetMapping(path = "/active")
    public List<PersonPrivateDataDto> getAllActiveUsers() {
        return adminService.getAllActivePersons();
    }

    @Override
    @GetMapping(path = "disabled")
    public List<PersonPrivateDataDto> getAllDisabledUsers() {
        return adminService.getAllDisabledPersons();
    }

}
