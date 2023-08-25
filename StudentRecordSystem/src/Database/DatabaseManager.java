package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grade;
import model.Module;
import model.Student; // Imported my Student class

public class DatabaseManager {

    private static DatabaseManager instance;
    private Connection connection;

    private DatabaseManager() {
        try {
            // Replaced with my actual database URL, username, and password
            String url = "C:/Users/lthet/Documents/CodingShenanigans/student_records.db";

            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO students (id, name, dob, semester) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getDob());
            preparedStatement.setInt(4, student.getSemester());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeStudent(String id) {
        try {
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editStudent(String id, String newName, String newDob, int newSemester) {
        try {
            String query = "UPDATE students SET name = ?, dob = ?, semester = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newDob);
            preparedStatement.setInt(3, newSemester);
            preparedStatement.setString(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllStudentIds() {
        List<String> studentIds = new ArrayList<>();
        try {
            String query = "SELECT id FROM students";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                studentIds.add(resultSet.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentIds;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addGrade(Grade grade) {
    }

    public void deleteGrade(String student, String module) {
    }

    public String getAllModuleIds() {
        return null;
    }

    public Grade[] getAllGrades() {
        return new Grade[0];
    }

    public void addModule(Module newModule) {
    }

    public void removeModule(String selectedCode) {
    }

    public void editModule(String selectedCode, String newName, int newCredits, int newSemester) {
    }

    public String getAllModuleCodes() {
        return null;
    }
}
