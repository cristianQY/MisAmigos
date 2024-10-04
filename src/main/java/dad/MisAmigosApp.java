package dad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MisAmigosApp extends Application {

    private final RootController rootController = new RootController();
    private BorderPane root;
    private Button friendButtom;
    private Button enemyButtom;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Mis Amigos");
        primaryStage.setScene(new Scene(rootController.getRoot()));
        primaryStage.show();

    }
}
