package com.data;

import java.awt.Dimension;

public class Canvas {
  private Dimension area;
  public Dimension getArea() {
	return area;
}
private String canvasId; 
  private static int renderCount = 0;
  
  public Canvas(Dimension dimArea,String cid)
  {
	  area = dimArea;
	  renderCount++;
	  canvasId=cid;
	  
  }
  public void finalize()
  {
	 System.out.println("\n***Canvas.finalizer for "+canvasId);
	 Dimension newDim = area.getSize();
	 System.out.println("The width is  "+newDim.getWidth());
	 System.out.println("The height is  "+newDim.getHeight());
	 
	 
  }
  
}
