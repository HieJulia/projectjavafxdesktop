package sample;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


/**
 * Main application class for starting the sample application
 */
public class Main extends Application {

    // A reference to the sample.model
    AudioConfigModel acModel = new AudioConfigModel();

    Text textDb;
    Slider slider;
    CheckBox mutingCheckBox;
    ChoiceBox genreChoiceBox;
    Color color = Color.color(0.66, 0.67, 0.69);


    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("/other/About.fxml"));/**/
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


        // Message
//        stage.setTitle("FXMLContactForm ");
//
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("ContactForm.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Scene scene = new Scene(root, 380, 150, Color.WHITE);
//        stage.setScene(scene);
//        stage.setMinWidth(200);
//        stage.setMinHeight(200);
//
//        stage.show();






// thich nghe nhac

        // nghe nhac cua muse

    }



    // Main
    public static void main(String[] args) {
        launch(args);
    }
}
