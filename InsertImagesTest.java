import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 *test class used to test the insertImgae function of the JDBC class
 */
public class InsertImagesTest {

	@Test
	public void insertImages_listOfImages_arrayOfStatus()
	{
		
		Image image1 = new Image(306, "'SONATA watch 101 image1'",  202);
		Image image2 = new Image(307, "'SONATA watch 101 image2'",  202);
		List<Image> imageList = new ArrayList<Image>();
		imageList.add(image1);
		imageList.add(image2);
		int computedOutput[] = JDBC.insertImages(imageList);
		for(int i : computedOutput)
		{
			System.out.println(i);
		}
		int expectedOutput[] = {1, 1};
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test(expected = AssertionError.class)
	public void insertImages_DuplicateData_AssertionError()
	{
		
		Image image1 = new Image(308, "'SONATA watch 101 image3'",  202);
		Image image2 = new Image(308, "'SONATA watch 101 image4'",  202);
		List<Image> imageList = new ArrayList<Image>();
		imageList.add(image1);
		imageList.add(image2);
		JDBC.insertImages(imageList);
	}
}
