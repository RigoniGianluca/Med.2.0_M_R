package com.example.med_webservice.api.model;

public class User {
    private final int id;
    private final String fname;
    private final String lname;
    private  final String codFiscale;
    private final String username;
    private final String email;
    private final String password;
    private final String userType;
    public User(int id, String fname, String lname, String codFiscale, String username, String email, String password, String type) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.codFiscale = codFiscale;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = type;
    }

    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() { return lname; }
    public String getCodFiscale() {
        return codFiscale;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getUserType() {
        return userType;
    }
}
