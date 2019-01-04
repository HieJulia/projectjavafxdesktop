# projectjavafxdesktop
Desktop application project created with Java FX 

## Project description
+ Company employees management system  
+ Company employees facial recognition detection system  
+ Save employees facial patterns for sample.other analysis 


## Project features 
+ Real time facial recognition   

+ Working ID extrac

+ Text detection - using tesseract - detect employee ID card - and save to database 


+ 










## Stack 
+ Java FX 
+ Maven 
+ Database : MySQL   
+ JDK 8 
+ OpenCV version 3 
    + OpenCV wrapper for Java - 







----- 



Process image 
    + Remove noise
    + Change the color of the image - HSV - get the contours easily 
    + Morphological operator 
        + 2 matrices of morphological operator dilation and erosion - process the image 
        + Result is matrix morphoutput that will be the partial out put 
    + Obj tracking 
        + findContours()
        + 