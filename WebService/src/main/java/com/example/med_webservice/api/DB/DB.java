package com.example.med_webservice.api.DB;
import com.example.med_webservice.api.model.User;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DB {
    private final Connection conn;

    public DB(String username, String password) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/med_db", username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        SetUp();
    }

    private void SetUp() {
        String filePath = "src/main/java/com/example/med_webservice/api/DB/setUp.sql";
        try {
            Statement statement= conn.createStatement();
            String[] queries = new String(Files.readAllBytes(Paths.get(filePath))).split(";");
            for (String query:queries)
                statement.execute(query + ";");
        } catch (SQLException e) {
            System.out.printf("SQL State: %s\n%s",e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ResultSet execute_query(PreparedStatement statement) {
        try {
            return statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private boolean query_execute(PreparedStatement statement) {
        try {
            statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public User getUser(String username, String password) throws SQLException {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM app_user WHERE username = ? AND password = ?;");
            query.setString(1, username);
            query.setString(2, password);
            ResultSet result = execute_query(query);
            if(result.next())
                return new User(
                        result.getInt("id"),
                        result.getString("fname"),
                        result.getString("lname"),
                        result.getString("codFiscale"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("userType")
                );
            else return null;
    }
    public boolean addUser(User user) throws SQLException {
        PreparedStatement query = conn.prepareStatement("INSERT INTO app_user (fname, lname, codFiscale, username, email, password, userType) VALUES (?, ?, ?, ?, ?, ?, ?);");
        query.setString(1, user.getFname());
        query.setString(2, user.getLname());
        query.setString(3, user.getCodFiscale());
        query.setString(4, user.getUsername());
        query.setString(5, user.getEmail());
        query.setString(6, user.getPassword());
        query.setString(7, user.getUserType());
        return query_execute(query);
    }
    public boolean removeUser(User user) throws SQLException {
        PreparedStatement query = conn.prepareStatement("DELETE FROM relationships WHERE patientId = ? OR doctorId = ?;");
        query.setInt(1, user.getId());
        query.setInt(2, user.getId());
        if (query_execute(query)) {
            query = conn.prepareStatement("DELETE FROM app_user WHERE id = ?;");
            query.setInt(1, user.getId());

            return query_execute(query);
        }
        return false;
    }
    public boolean addRelation(int doctorId, int patientId) throws SQLException {
        PreparedStatement query = conn.prepareStatement("INSERT INTO relationships (doctorId, patientId) VALUES (?, ?);");
        query.setInt(1, doctorId);
        query.setInt(2, patientId);

        return query_execute(query);
    }
}