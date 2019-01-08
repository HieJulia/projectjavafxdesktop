+ Background and foreground 
+ Text segmentation 
    + Find where is the text - locate and extract it 
        + Connect component analysis - connected pixel in the image - 
        + Classifiers to search - trained letter texture patterns -
    + Create connected area - 
        + Detect block of letters 
        + Dilation morphological operator
        + Identify paragraph blocks 
        + Create OCR preprocessor -   
        + Text extraction and skewing adjustment 
            + Extract text and adjust text skew 
        + Load the image 
            + call binarization function 
            + find text region 
            + show each region in a window
            
            + Tesseract OCR - 
            
            
            
            
            
            
+ Step 
    + Import source picture 
    + Convert to grayscale 
    + Gaussian blur with 3x3 or 5x5 filter 
    + Sobel filter to find vertical edge 
    + Get binary image 
    + Morphological close operation using suitable structuring element 
    + Find contours of the resulting image 
    + 
    
    
    
    -------
    
    
    
    + Source image 
    + Gray scale 
    + Gaussian blur 
    + Adaptive threshold  
    
    
    
    