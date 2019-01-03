package sample.detect_human_hair;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


public class HairDetection extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load XML resource
        // load the FXML resource
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("HairDetection.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("HairDetection.fxml"));

        Scene scene = new Scene(root);
        // Set title -
        stage.setTitle("Detect Human Hair");
        // Play with Open CV

        stage.setScene(scene);

        // Show the UI
        stage.show();

        // Init the controller
//        final FXMLDocumentController controller = loader.getController();



        // Set video device
        int videodevice = 1;

        // controller . initController - video


    }

    // Run main application
    public static void main(String[] args) {

        // Load the native OpenCV library
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);




        launch(args);
    }

}


