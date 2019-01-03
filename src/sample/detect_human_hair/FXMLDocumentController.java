package sample.detect_human_hair;


import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;


// Hair detection controller
public class FXMLDocumentController implements Initializable {


    // View model - ImageVIew 
    @FXML private ImageView imgStep1;
    @FXML private ImageView imgStep2;
    @FXML private ImageView imgStep3;
    @FXML private ImageView imgStep4;
    @FXML private ImageView imgStep5;
    @FXML private ImageView imgStep6;
    @FXML private ImageView imgStep7;
    @FXML private ImageView imgStep8;

    Image img1;
    Image img2;
    Image img3;
    Image img4;
    Image img5;
    Image img6;
    Image img7;
    Image img8;


    // Source file 
    File imgFile1;
    File imgFile2;
    File imgFile3;
    File imgFile4;
    File imgFile5;
    File imgFile6;
    File imgFile7;
    File imgFile8;

    // OpenCV Operation 
    OpenCVOperation obj;

    // OpenCV object that realizes the video capture

//    private VideoCapture capture  = new VideoCapture(0);
    // A flag to change the button behaviour
    private static boolean cameraActive = false;


    // Settings

    // Set video device




    FileChooser fileChooser = new FileChooser();
    String path;

    String[] results = {"filler0", "filler1", "face2_grabcut_quantized", "face3_skindetection_quantized", "face4_morphedImage", "face5_difference", "face6_erosion", "face7_contour", "face8_dilution" };

    FXMLLoader fxmlloader = new FXMLLoader();

    // Handle load action



    // no kha la


    // thanh nien nay nghe nhac EDM
    @FXML
    private void handleLoadAction(ActionEvent event) {
        fileChooser.setTitle("Open an Image");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.jpeg,*.jpg, *.png) ","*.jpeg","*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        imgFile1 = fileChooser.showOpenDialog(new Stage());;
        img1 = new Image(imgFile1.toURI().toString());
        imgStep1.setImage(img1);
        //get parent directory
        path = imgFile1.getParent();

        System.out.println(imgFile1.toURI().toString());
    }


    // Handle Generate Action - ActionEvent event 
    @FXML
    private void handleGenerateAction(ActionEvent event)
    {
        // System.out.println("File name is:" +imgFile1.getName());

        obj = new OpenCVOperation(path+"/",imgFile1.getName(),results);

        // take the object - extract the foreground part


        obj.testGrabCut(); // test grab cut
        //obj.skinSegmentation_WithThreshold();

        // detect skin segmentation

        obj.skinSegmentation();
        //obj.skinDetection2();

            // set quantized image

        obj.setQuantizedImages();


        // Find image difference

        obj.findImageDifference();


        obj.performErosion_Dilution();



        obj.findContours();// find contours



        // so thoch c



        obj.predict_hair_color();


        // predict hair color

        // Generate file to load images 
        imgFile2 = new File(path,results[2]+".png");        //grabcut quantized
        imgFile3 = new File(path,results[3]+".png");        //skin detection quantized
        imgFile4 = new File(path,results[4]+".png");        //morphed Image
        imgFile5 = new File(path,results[5]+".png");        //face difference o/p
        imgFile6 = new File(path,results[6]+".png");        //face erosion
        imgFile7 = new File(path,results[7]+".png");        //face contour
        imgFile8 = new File(path,results[8]+".png");        //face dilution


        //Generate images using files

        // Generate images using files 
        img2 = new Image(imgFile2.toURI().toString());
        img3 = new Image(imgFile3.toURI().toString());
        img4 = new Image(imgFile4.toURI().toString());
        img5 = new Image(imgFile5.toURI().toString());
        img6 = new Image(imgFile6.toURI().toString());
        img7 = new Image(imgFile7.toURI().toString());
        img8 = new Image(imgFile8.toURI().toString());

        //Load images in Output Window
        imgStep2.setImage(img2);
        imgStep3.setImage(img3);
        imgStep4.setImage(img4);
        imgStep5.setImage(img5);
        imgStep6.setImage(img6);
        imgStep7.setImage(img7);
        imgStep8.setImage(img8);




    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

// su dung image co san -> extract hair - put to the project file



    // Project 2 -
    //=========== Functions for handling Video detection
//    public void setClosed(){
//        // Close thread on window close
//        cameraActive = false;
//    }
//
//
//    /**
//     * Mat to buffered images
//     * 1. int width of the image
//     * 2. Init buffer image
//     * 3. Print target image pixel
//     * @param matBGR
//     * @return image
//     */
//    public BufferedImage matToBufferedImage(Mat matBGR) {
//        int width = matBGR.width(), height = matBGR.height(), channels = matBGR.channels();
//        byte[] sourcePixels = new byte[width * height * channels];
//        matBGR.get(0, 0, sourcePixels);
//        BufferedImage image;
//        if (matBGR.channels() > 1) {
//            image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
//        } else {
//            image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
//        }
//        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
//        System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);
//        return image;
//    }
//
//    /**
//     *
//     * Convert a Mat object OpenCV in the corresponding image for Java FX
//     *
//     * @param frame
//     *            the {@link Mat} representing the current frame
//     * @return the {@link Image} to show
//     */
//    private Image mat2Image(Mat frame) {
//        try {
//            return SwingFXUtils.toFXImage(matToBufferedImage(frame), null);
//        } catch (Exception e) {
//            System.out.println("ERROR - cannot convert mat object from opencv in the corresponding image for Java FX " + e);
//
//            return null;
//        }
//    }
//
//    /**
//     * Process a frame
//     * @param
//     * @return
//     */
//    private Mat processMat(Mat matToShow) {
//        // convert the image to gray scale
//        //Imgproc.cvtColor(matToShow, matToShow, Imgproc.COLOR_BGR2GRAY);
//        return matToShow;
//    }
//
//
//    /**
//     * Get a frame from the opened video stream - if any
//     * @param
//     * @return frame
//     * 1. Check if the capture is open
//     *  - yes
//     *      - read the current frame
//     *  - no
//     *      - log error
//     */
//    private Mat grabFrame() {
//        // init everything
//        Mat frame = new Mat();
//
//        // check if the capture is open
//        if (this.capture.isOpened()) {
//            try {
//                // read the current frame
//                this.capture.read(frame);
//
//                // if the frame is not empty, process it
//                if (!frame.empty()) {
//
//                }
//
//            } catch (Exception e) {
//                // log the error
//                System.err.println("Exception during the image elaboration: " + e);
//            }
//        }
//
//        return frame;
//    }
//
//
//    /**
//     * Always update the UI from the main thread
//     *
//     */
//    private void updateUIObjects() {
//        Platform.runLater(() -> {
//            // Update UI Objects like: Textfield.setText() , Button.set..() ,
//            // Window.Resize...()
//            //Set FPS
//            /*fps.setText(""+capture.get(5));*/
//        });
//    }
//
//    /**
//     * mat -> buffer image
//     * 1. source - fastest code - output : bufferimage - image
//     *
//     * 2. get pixels of the image
//     * //data buffer
//     */
//
//    public BufferedImage Mat2BufferedImage(Mat m){
//        // source: http://answers.opencv.org/question/10344/opencv-java-load-image-to-gui/
//        // Fastest code
//        // The output can be assigned either to a BufferedImage or to an Image
//
//        int type = BufferedImage.TYPE_BYTE_GRAY;
//        if ( m.channels() > 1 ) {
//            type = BufferedImage.TYPE_3BYTE_BGR;
//        }
//        int bufferSize = m.channels()*m.cols()*m.rows();
//        byte [] b = new byte[bufferSize];
//        m.get(0,0,b); // get all the pixels
//        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
//        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
//        System.arraycopy(b, 0, targetPixels, 0, b.length);
//        return image;
//
//    }
//
//
//    /**
//     * Detect
//     * 1. Init Mat image
//     * 2. Copy to
//     * 3. Detect multi scale
//     */
//    public Mat detect(Mat inputframe){
//        Mat mRgba=new Mat();
//        Mat mGrey=new Mat();
//        MatOfRect faces = new MatOfRect();
//
//        inputframe.copyTo(mRgba);
//        inputframe.copyTo(mGrey);
//
//        Imgproc.cvtColor( mRgba, mGrey, Imgproc.COLOR_BGR2GRAY);
//        Imgproc.equalizeHist( mGrey, mGrey );
//
//        face_cascade.detectMultiScale(mGrey, faces);
//        int detectedFaces = faces.toArray().length;
//
//        System.out.println(String.format("Detected %s faces", detectedFaces));
//
//        for(Rect rect:faces.toArray()){
//            Point center= new Point(rect.x + rect.width*0.5, rect.y + rect.height*0.5 );
//            Imgproc.ellipse( mRgba, center, new Size( rect.width*0.5, rect.height*0.5), 0, 0, 360, new Scalar( 255, 0, 255 ), 4, 8, 0 );
//            //Core.rectangle(mRgba, new Point(rect.width*0.5, rect.height*0.5), center, new Scalar( 0, 255, 255 ), 4, 8, 0);
//            croppedImage = Mat2BufferedImage(mGrey);
//        }
//        return mRgba;
//    }
//
//    /**
//     * Always Update UI from main thread
//     */
//    private void setFrametoImageView(Image frame) {
//        Platform.runLater(() -> {
//            currentFrame.setImage(frame);
//            currentFrame.setFitWidth(ImageViewPane.getWidth());
//            currentFrame.setFitHeight((ImageViewPane.getHeight()));
//            // set Image height/width by window size
//        });
//
//    }
//

    /**
     * Start camera
     * 1. Start video capture
     * 2. Check if video stream available
     *  // If camera active
     *      // Grab frame
     *      // Process frame
     *      // Convert the Mat obj (OpenCV) -> Image (JavaFX) = for output
     *
     *      // Update ImageView
     *
     *
     *
     *
     */



}




