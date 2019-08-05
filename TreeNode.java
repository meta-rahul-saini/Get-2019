import java.util.Date;

/**TreeNode class represents node(folder) in directory structure
 * @author Rahul
 *
 */
public class TreeNode {

	Date date = null;
	String nodeName = null;
	ChildNodeList childNodes;
	TreeNode parentNode = null;
	
	float data;

	// constructor 
	public TreeNode(String directoryName) {
		this.childNodes = new ChildNodeList();
		this.date = new Date();
		this.nodeName = directoryName;
	}
	
	
	// getters and setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}


	public TreeNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}

	

}
