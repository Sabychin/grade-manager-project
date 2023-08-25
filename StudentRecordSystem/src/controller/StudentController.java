package controller;

import Database.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Student;

public class StudentController {

    @FXML private TextField nameTextField;
    @FXML private TextField idTextField;
    @FXML private TextField dobTextField;
    @FXML private TextField semesterTextField;
    @FXML private ListView<String> studentListView;

    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    @FXML
    private void addStudent(ActionEvent event) {
        String id = idTextField.getText();
        String name = nameTextField.getText();
        String dob = dobTextField.getText();
        int semester = Integer.parseInt(semesterTextField.getText());

        Student newStudent = new Student(id, name, dob, semester);
        databaseManager.addStudent(newStudent);

        // Cleared the text fields after adding
        idTextField.clear();
        nameTextField.clear();
        dobTextField.clear();
        semesterTextField.clear();

        refreshStudentList();
    }

    @FXML
    private void removeStudent(ActionEvent event) {
        String selectedId = studentListView.getSelectionModel().getSelectedItem();
        databaseManager.removeStudent(selectedId);
        refreshStudentList();
    }

    @FXML
    private void editStudent(ActionEvent event) {
        String selectedId = studentListView.getSelectionModel().getSelectedItem();
        String newName = nameTextField.getText();
        String newDob = dobTextField.getText();
        int newSemester = Integer.parseInt(semesterTextField.getText());

        databaseManager.editStudent(selectedId, newName, newDob, newSemester);
        refreshStudentList();
    }

    private void refreshStudentList() {
        studentListView.getItems().clear();
        studentListView.getItems().addAll(databaseManager.getAllStudentIds());
    }
}
