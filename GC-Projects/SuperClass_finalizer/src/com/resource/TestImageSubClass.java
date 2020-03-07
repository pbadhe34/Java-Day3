package com.resource;




public class TestImageSubClass {

	 
	public static void main(String[] args) {
		int numImages = 34000;
		System.out.println("TestImageCanvas.main()");
		try {
			
		 ImageCanvas[] images = new RgbImage[numImages]; 
		 int width = 24;
		 int height = 45;
		 int size = (width * height)/2;
		 
		 for(int i = 0; i < numImages; i++)
		 {
			 images[i] = new RgbImage("newImage "+i);
			 images[i].init(width, height, size);			 
		 }
		 
		 for(ImageCanvas img : images)
		 {
			 
				img.renderImage();
			
		 }
		 images = null;
		 
		 
		} catch (Exception e) {			 
			e.printStackTrace();
		}
		 
			while(numImages > 0) 
			{
				//numImages--;
			}
		 
         System.out.println("TestImages for ImageCanvas.main() exit");
	}

}
