package sample.text_detection;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

// Text detection - con nho nay binh thuong
public class TextDetection {

    // Source image
    final String sourceImage = "sample_photo.jpg";

    final String pathSourceImage = "preprocess/True_Image.png";


    Mat img = new Mat();
    img = Imgcodecs.imread("sample_photo.jpg");
    Imgcodecs.imwrite("preprocess/True_Image.png", img);

    // Gray scale - for extract image


    // Gaussian blur - for extract pixel of the image


    // Adaptive threshold

    // OCR - via tesseract - tess4j

        // File - file just do image processing

        // create new instance of tesseract


        // set language - en


        // set tess variable -


        // con nho dang rat la hard core



}


