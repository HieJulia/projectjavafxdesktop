package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;




/**
 * Main application class for starting the sample application
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // Set title
        primaryStage.setTitle("Hello World");

        Group group = new Group();
        Scene scene = new Scene(group, 300, 250);

        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);

        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });


        group.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();










    }



    // Main
    public static void main(String[] args) {
        launch(args);
    }
}
