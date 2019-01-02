package sample.detect_human_hair;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class HairDetection extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("HairDetection.fxml"));

        Scene scene = new Scene(root);
        // Set title -
        stage.setTitle("Hair Region Extractor");

        stage.setScene(scene);

        stage.show();
    }

    //Main
    public static void main(String[] args) {
        launch(args);
    }

}