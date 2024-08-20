package session11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
        @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("view/datacatalogue.fxml")));

        primaryStage.setScene(scene);

        primaryStage.setTitle("Product Catalogue");
        primaryStage.show();

        Scene scene1 = new Scene(FXMLLoader.load(getClass().getResource("view/simpanel.fxml")));
        primaryStage.setScene(scene1);

        primaryStage.setTitle("Simcard Catalogue");
        primaryStage.show();
    }
}

