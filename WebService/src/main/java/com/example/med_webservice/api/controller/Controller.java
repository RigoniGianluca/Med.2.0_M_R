package com.example.med_webservice.api.controller;

import com.example.med_webservice.api.DB.DB;
import com.example.med_webservice.api.model.User;
import com.example.med_webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final DB db = new DB("root", "");
    private final UserService userService;
    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    // GET DATA

    @GetMapping("/patient")
    public User getPatient(@RequestParam String username, String password) {
        return userService.getUser(username, password, db);
    }
    @GetMapping("/doctor")
    public User getDoctor(@RequestParam String username, String password) {
        return userService.getUser(username, password, db);
    }

    // SEND DATA

    @PostMapping("/add_user")
    public boolean addUser(@RequestParam String fname, String lname, String codFiscale, String username, String email,String password, String userType) {
        return userService.addUser(fname, lname, codFiscale, username, email, password, userType, db);
    }
    @PostMapping("/new_patient")
    public boolean addPatient(@RequestParam int doctorId, int patientId) {
        return userService.addPatient(doctorId, patientId, db);
    }
    @DeleteMapping("/remove_user")
    public boolean removeUser(@RequestParam int id) {
        return userService.removeUser(id, db);
    }
}
