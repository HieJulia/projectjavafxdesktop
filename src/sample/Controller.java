package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    @FXML
    private TextField firstNameField;
    @FXML private TextField lastNameField;

    @FXML
    protected void saveContactAction(javafx.event.ActionEvent event) {
        System.out.println("Saving the following information: ");
        System.out.println("First Name: " + firstNameField.getText());
        System.out.println(" Last Name: " + lastNameField.getText());
    }
}



