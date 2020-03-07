package com.resource;
 


public class RgbImage extends ImageCanvas {
	
	 private int rgbData[];

	public RgbImage(String idVal) {
		
		super(idVal);
		 
	}
	
	public void init(int width,int height,int size)
	  {
		super.init(width, height, size);
		
		  rgbData = new int[size];
		  for(int i = 0; i <size; i++ )
		  {
			   int contrastRatio = 10;
			   rgbData[i] = (points.length - i)+(width *height)*contrastRatio;
		  }	  
		      
	  }

}
