import com.data.Image;


public class TestImages {

	 
	public static void main(String[] args) {
		int numImages = 34000;
		try {
			
		 Image[] images = new Image[numImages]; 
		 int width = 24;
		 int height = 45;
		 int size = (width * height)/2;
		 
		 for(int i = 0; i < numImages; i++)
		 {
			 images[i] = new Image("newImage "+i);
			 images[i].init(width, height, size);			 
		 }
		 
		 for(Image img : images)
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
		 
         System.out.println("TestImages.main() exit");
	}

}
