
/**
 *image class to hold the image data or a row in database
 */
public class Image {

	private int image_id;
	private String image_title;
	private int product_id;
	
	public Image(int image_id, String image_title, int product_id) {
		super();
		this.image_id = image_id;
		this.image_title = image_title;
		this.product_id = product_id;
	}

	// getter and setters
	public int getImage_id() {
		return image_id;
	}

	public String getImage_title() {
		return image_title;
	}

	public int getProduct_id() {
		return product_id;
	}
}
