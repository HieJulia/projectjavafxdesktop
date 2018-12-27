package sample;


import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

/**
 * Handle user interaction with UI
 */
public class Controller {

    // Label helloWorld
    public Label helloWorld;


    // sayHelloWorld
    public void sayHelloWorld(ActionEvent actionEvent){
        helloWorld.setText("Helloworld");

    }
}



