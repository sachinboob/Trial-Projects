package com.sikuli.demo;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException; 

public class TesseractDemo {

	public TesseractDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
    { 
        Tesseract tesseract = new Tesseract(); 
        try { 
  
            tesseract.setDatapath("C:\\Users\\sachin.boob\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata"); 
  
            // the path of your tess data folder 
            // inside the extracted file 
            String text 
                = tesseract.doOCR(new File("C:\\Users\\sachin.boob\\Downloads\\For-complex-OCR.JPG")); 
  
            // path of your image file 
            System.out.print(text); 
        } 
        catch (TesseractException e) { 
            e.printStackTrace(); 
        } 
    } 
}
