/*DROP DATABASE med_db;*/
CREATE DATABASE IF NOT EXISTS med_db;
USE med_db;
CREATE TABLE IF NOT EXISTS app_user(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fname VARCHAR(50),
    lname VARCHAR(50),
    codFiscale VARCHAR(16) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    userType ENUM('patient', 'doctor') NOT NULL
);
CREATE TABLE IF NOT EXISTS relationships(
    doctorId INT NOT NULL,
    patientId INT NOT NULL,
    FOREIGN KEY (doctorId) REFERENCES app_user(id),
    FOREIGN KEY (patientId) REFERENCES app_user(id)
);