package ru.exam.ruzana.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.exam.ruzana.controller.AuthenticationController;
import ru.exam.ruzana.controller.BaseUserDataController;

@RestController
@RequestMapping(path = "/")
public class AuthenticationControllerImpl extends BaseUserDataController implements AuthenticationController {
    @Override
    @RequestMapping(path = "login")
    public void login() {

    }
}
