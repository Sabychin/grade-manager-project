package controller;

import Database.DatabaseManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Grade;

public class GradeController {

    @FXML private ComboBox<String> studentComboBox;
    @FXML private ComboBox<String> moduleComboBox;
    @FXML private TextField gradeTextField;
    @FXML private TableView<GradeRow> gradeTableView;
    @FXML private TableColumn<GradeRow, String> studentColumn;
    @FXML private TableColumn<GradeRow, String> moduleColumn;
    @FXML private TableColumn<GradeRow, String> gradeColumn;

    private ObservableList<GradeRow> gradeList = FXCollections.observableArrayList();
    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    @FXML
    private void initialize() {
        studentColumn.setCellValueFactory(cellData -> cellData.getValue().student);
        moduleColumn.setCellValueFactory(cellData -> cellData.getValue().module);
        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().grade);
        loadStudentComboBox();
        loadModuleComboBox();
        loadGradeTable();
    }

    @FXML
    private void addGrade(ActionEvent event) {
        String studentId = studentComboBox.getValue();
        String moduleId = moduleComboBox.getValue();
        int gradeValue = Integer.parseInt(gradeTextField.getText());

        Grade grade = new Grade(studentId, moduleId, gradeValue);
        databaseManager.addGrade(grade);
        gradeList.add(new GradeRow(studentId, moduleId, String.valueOf(gradeValue)));
        clearInputs();
    }

    @FXML
    private void deleteGrade(ActionEvent event) {
        int selectedIndex = gradeTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            GradeRow selectedRow = gradeTableView.getItems().get(selectedIndex);
            databaseManager.deleteGrade(selectedRow.getStudent(), selectedRow.getModule());
            gradeList.remove(selectedIndex);
        }
    }

    private void loadStudentComboBox() {
        // Implement loading student IDs into studentComboBox
        studentComboBox.setItems(FXCollections.observableArrayList(databaseManager.getAllStudentIds()));
    }

    private void loadModuleComboBox() {
        // Implement loading module IDs into moduleComboBox
        moduleComboBox.setItems(FXCollections.observableArrayList(databaseManager.getAllModuleIds()));
    }

    private void loadGradeTable() {
        // Implement loading grades into gradeList and populating gradeTableView
        gradeList.clear();
        for (Grade grade : databaseManager.getAllGrades()) {
            gradeList.add(new GradeRow(grade.getStudentId(), grade.getModuleId(), String.valueOf(grade.getGrade())));
        }
        gradeTableView.setItems(gradeList);
    }

    private void clearInputs() {
        studentComboBox.getSelectionModel().clearSelection();
        moduleComboBox.getSelectionModel().clearSelection();
        gradeTextField.clear();
    }

    public class GradeRow {
        private final SimpleStringProperty student;
        private final SimpleStringProperty module;
        private final SimpleStringProperty grade;

        public GradeRow(String student, String module, String grade) {
            this.student = new SimpleStringProperty(student);
            this.module = new SimpleStringProperty(module);
            this.grade = new SimpleStringProperty(grade);
        }

        public String getStudent() {
            return student.get();
        }

        public String getModule() {
            return module.get();
        }

        public String getGrade() {
            return grade.get();
        }
    }
}
