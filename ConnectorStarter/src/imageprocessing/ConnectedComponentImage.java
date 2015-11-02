package imageprocessing;

import edu.princeton.cs.introcs.Picture;
import java.awt.Color;

/*************************************************************************
 * Compilation: javac ConnectedComponentImage.java
 * 
 * The <tt>ConnectedComponentImage</tt> class
 * <p>
 * You do the rest....
 * 
 * @author 
 *************************************************************************/
public class ConnectedComponentImage 
  {
	 Picture pic = new Picture("images/bacteria.bmp");
	 int colourThreshold = 127;
	 int w = pic.width();
	 int h = pic.height();
	 int nextLabel = 1;

	/**
	 * Initialise fields
	 * 
	 * @param fileLocation
	 */
    public ConnectedComponentImage()
    {
		Picture pic = new Picture("images/bacteria.bmp");
		int w = pic.width();
		int h = pic.height();
		int nextLabel = 1;
		int [] linked;
		int [][] neighbours = new int [w][h];
		
		
		for (int a = 0; a < h; a++)
        {
			for (int b = 0; b < w; b++)
			{
				if (pic.get(a, b) != Color.BLACK)
				{
					 for (int x = -1; x <= 1; x++)
					 {
		                    for (int y = -1; y <= 1; y++)
		                    {
		                        Color p = pic.get(a + x, b + y);
		                        if (p != Color.BLACK )
		                        {
		                            neighbours[a][b] = nextLabel;
		                        }
		                        else
		                        {
		                        	nextLabel++;
		                        }
			            	}
			         }
		        }
	        }
			nextLabel = 1;
			for (int m = 0; m < h; m++)
			{
				for (int n = 0; n < w; n++)
				{
					if (pic.get(m, n) != Color.BLACK)
					{
						int[] connectedLabels = new int[4];
						int index = 0;
						for(int x = -1; x <= 1; x++)
						{
							for (int y = -1;y <= 1; y++)
							{
								connectedLabels[index] = labels[][],
								index ++;
							}
						}
						int lowestLabel = -1;
						for(int z = 0; z < 4; z++)
						{
							if (connectedfLabels[z] != 0)
							{
								lowestLabel = connectedLabel[z];
							}
						}
						
						for(int c = 0; c < 4; c++)
						{
							int label = connectedLabels[0];
							if(label < lowestLabel && label != 0)
							{
								lowestLabel = label;
							}
						}
						if(neighbours[a][b] != lowestLabel)
						{
							neighbours[a][b] = lowestLabel;
						}
					}
		          }
              }
        }
    }
	/**
	 * Returns the number of components identified in the image.
	 * 
	 * @return the number of components (between 1 and N)
	 */
    public int countComponents() 
	{
		return 0;
	}

	/**
	 * Returns the original image with each object bounded by a red box.
	 * 
	 * @return a picture object with all components surrounded by a red box
	 */
	public Picture identifyComonentImage() 
	{
		return null;
	}

	/**
	 * Returns a picture with each object updated to a random colour.
	 * 
	 * @return a picture object with all components coloured.
	 */
	public Picture colourComponentImage() 
	{
		return null;
	}

	public Picture getPicture() 
	{
		//Auto-generated method stub
		return pic;
	}

	/**
	 * Returns a binarised version of the original image
	 * 
	 */
	public Picture binaryComponentImage()
	{
        Picture pic = new Picture("images/bacteria.bmp");
        Picture binary = new Picture(pic);
        Picture greyScale = new Picture(pic);
        for(int i = 0; i < pic.width(); i++)
        {
        	for(int j =0; j < pic.width(); j++)
        	{
        		Color color = pic.get(i , j);
        		greyScale.set(i, j, Luminance.toGray(color));
        		double luminance = Luminance.lum(color);
        		if (luminance >= colourThreshold)
        		{
        			binary.set(i, j, Color.WHITE);
        		}
        		else
        		{
        			binary.set(i, j, Color.BLACK);
        		}
        	}
        }
        binary.show();
        return binary;    
	}

}
