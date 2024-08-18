package session11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
        @Override
    public void start(Stage primaryStage) throws Exception {
        //todo fix this part
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("view/datacatalogue.fxml")));

        primaryStage.setScene(scene);

        primaryStage.setTitle("Product Catalogue");
        primaryStage.show();

    }
}

