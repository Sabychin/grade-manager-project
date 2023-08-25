package controller;

import Database.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Module;

public class ModuleController {

    @FXML private TextField moduleNameTextField;
    @FXML private TextField moduleCodeTextField;
    @FXML private TextField creditsTextField;
    @FXML private TextField semesterTextField;
    @FXML private ListView<String> moduleListView;

    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    @FXML
    private void addModule(ActionEvent event) {
        String code = moduleCodeTextField.getText();
        String name = moduleNameTextField.getText();
        int credits = Integer.parseInt(creditsTextField.getText());
        int semester = Integer.parseInt(semesterTextField.getText());

        Module newModule = new Module(code, name, credits, semester);
        databaseManager.addModule(newModule);

        // Cleared the text fields after adding
        moduleCodeTextField.clear();
        moduleNameTextField.clear();
        creditsTextField.clear();
        semesterTextField.clear();

        refreshModuleList();
    }

    @FXML
    private void removeModule(ActionEvent event) {
        String selectedCode = moduleListView.getSelectionModel().getSelectedItem();
        databaseManager.removeModule(selectedCode);
        refreshModuleList();
    }

    @FXML
    private void editModule(ActionEvent event) {
        String selectedCode = moduleListView.getSelectionModel().getSelectedItem();
        String newName = moduleNameTextField.getText();
        int newCredits = Integer.parseInt(creditsTextField.getText());
        int newSemester = Integer.parseInt(semesterTextField.getText());

        databaseManager.editModule(selectedCode, newName, newCredits, newSemester);
        refreshModuleList();
    }

    private void refreshModuleList() {
        moduleListView.getItems().clear();
        moduleListView.getItems().addAll(databaseManager.getAllModuleCodes());
    }
}
