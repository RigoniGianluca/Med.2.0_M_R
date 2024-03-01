package com.tpsit.med_20_r_m
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DBConn {

    fun connDatabase(): Connection?{
        val connection: Connection?
        val username = "root"
        val password = ""
        val url = "jdbc:mysql://http://localhost/phpmyadmin:3306/Med_2.0_MR"

        try{
            Class.forName("com.mysql.jdbc.Driver")
            connection = DriverManager.getConnection(url, username, password)
        }catch(e: SQLException){
            return null
        }catch(e: ClassNotFoundException){
            e.printStackTrace()
            return null
        }

        return connection
    }

}
