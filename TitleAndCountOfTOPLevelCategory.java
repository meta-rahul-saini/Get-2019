
/**
 *class to hold the data returned by the query of fetching category name and count of sub category of top 
 *level parent category
 */
public class TitleAndCountOfTOPLevelCategory {

	private String title;
	private int count;
	
	public TitleAndCountOfTOPLevelCategory(String title, int count) {
		super();
		this.title = title;
		this.count = count;
	}
	// getters 
	public String getTitle() {
		return title;
	}

	public int getCount() {
		return count;
	}

	
}
