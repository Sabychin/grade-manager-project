package Main;

import javafx.stage.Stage;
import jdk.internal.access.JavaNioAccess;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage primaryStage) throws IOException {

    }

    @Override
    public <Stage, Parent> void start(Stage primaryStage) throws IOException {
        // Load the main FXML view
        JavaNioAccess FXMLLoader = null;
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));

        // Set up the scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Record System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static void launch(String[] args) {
    }
}
