package ru.exam.ruzana.controller;

public interface AuthenticationController {
    /**
     * Authentication by mail and password. If the data is entered incorrectly,
     * an error will be returned that such a user does not exist
     * To log out, it is necessary to call '/logout' url
     * @return
     */
    void login();

}
