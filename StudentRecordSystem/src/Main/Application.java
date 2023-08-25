package Main;

import java.io.IOException;

public abstract class Application {
    public abstract void start(Stage primaryStage) throws IOException;

    public abstract <Stage, Parent> void start(Stage primaryStage) throws IOException;
}
