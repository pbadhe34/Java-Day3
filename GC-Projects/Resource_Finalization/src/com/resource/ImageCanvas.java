package com.resource;

import java.awt.Dimension;
import java.awt.Point;

public class ImageCanvas {
	
	  private Point points[];
	  private Dimension dim;
	  private int imageData[];
	  private static String id;
	  
	  private  Canvas drawArea= null;
	  
	  public ImageCanvas(String idVal)
	  {
		  id = idVal;		 
		  
	  }
	  
	  public void init(int width,int height,int size)
	  {
		  imageData = new int[size];
		  dim = new Dimension();
		  dim.setSize(width,height);
		  points = new Point[size/2];
		  
		  
		  drawArea = new Canvas(dim,id); 
		  
		  for(int i = 0; i <points.length; i++ )
		  {
			  points[i]= new Point((width * height)/(i+1) + (points.length - i),(height - i)+width*2);			   
		  }
		  
		  for(int i = 0; i <size; i++ )
		  {
			   int contrastRatio = 10;
			   imageData[i] = (points.length - i)+(width *height)*contrastRatio;
		  }	  
		      
		  
	  }
	  public void renderImage() throws Exception
	  {
		 // internalImage.renderImage();
		 // System.out.println("Image-renderImage()");
		  if(imageData[imageData.length -100] < 1200)
			  throw new Exception("The ImageCanvas error..");
	  }
	  
	  
	  public synchronized void finalize()
	  {
		 // System.out.println("Inside the Image-finalize() for  "+id);
		   
		  System.out.println("ImageCanvas-finalizer for "+id);
		  imageData = null;
		  points = null;
		  //dim = null;		
		  drawArea.getArea().setSize(11, 0);
		  drawArea.dispose();
		  
		  
	  }
	  

}
