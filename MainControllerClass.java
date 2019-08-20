import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *controller class used to perform the operation
 */
public class MainControllerClass {

	public static void main(String[] args) throws SQLException {

		System.out.println(JDBC.getOrdersInShippedState(603));
		
		Image image1 = new Image(306, "'SONATA watch 101 image1'",  202);
		Image image2 = new Image(307, "'SONATA watch 101 image2'",  202);
		List<Image> imageList = new ArrayList<Image>();
		imageList.add(image1);
		imageList.add(image2);
		System.out.println(JDBC.insertImages(imageList)[1]);
		
		System.out.println(JDBC.deleteProductsWhichAreNotBoughtSinceLastOneYear());
		
		System.out.println(JDBC.getTitleAndCountOfTopParentCategory());
		
	}
}
