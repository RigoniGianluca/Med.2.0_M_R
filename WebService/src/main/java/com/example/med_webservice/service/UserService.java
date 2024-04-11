package com.example.med_webservice.service;

import com.example.med_webservice.api.DB.DB;
import com.example.med_webservice.api.model.User;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    public User getUser(String username, String password, DB db) {
        try {
            return db.getUser(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addUser(String fname, String lname, String codFiscale, String username, String email, String password, String userType, DB db) {
        try {
            return db.addUser(new User(0, fname, lname, codFiscale, username, email, password, userType));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeUser(int id,  DB db) {
        try {
            return db.removeUser(new User(id, "", "", "", "", "", "", ""));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addPatient(int doctorId, int patientId, DB db) {
        try {
            return db.addRelation(doctorId, patientId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
