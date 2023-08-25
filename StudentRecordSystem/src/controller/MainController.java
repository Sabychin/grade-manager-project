package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    @FXML
    private void openStudentView(ActionEvent event) throws IOException {
        openView("/view/StudentView.fxml", "Student View");
    }

    @FXML
    private void openModuleView(ActionEvent event) throws IOException {
        openView("/view/ModuleView.fxml", "Module View");
    }

    @FXML
    private void openGradeView(ActionEvent event) throws IOException {
        openView("/view/GradeView.fxml", "Grade View");
    }

    private void openView(String fxmlPath, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }
}
