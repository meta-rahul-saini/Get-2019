
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class BSTDictionary {
	static final String FILE_PATH = "C:\\Users\\Rahul\\Downloads\\test.json";
	BSTNode root =  null;
	BSTLinkedList sortedList = new BSTLinkedList();
	BSTLinkedList sortBtKeyList = new BSTLinkedList();
	
	JSONArray jsonArr = null;
	
	public JSONArray readJsonFile(){
		
		// creating parser instance to parse json file
		JSONArray jsonArray = null;
		String key = null;
		String value = null;
		// Use FileReader to read JSON file and pass it to parser
		try 
        {
			 JSONParser parser = new JSONParser();
		     jsonArray = (JSONArray) parser.parse(new FileReader(
		        		FILE_PATH));
		     
		     //Read JSON file
		      for (Object o : jsonArray) {
		            JSONObject node = (JSONObject) o;
		            key = (String) node.get("key");
		            value = (String) node.get("value");
		            
		            // adding the key-value to disctionary
		            this.insert(key, value);
		        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		catch (Exception e) {
			e.printStackTrace();
		}
        return jsonArray;
	}


	/**function used to search element in BST and return the corresponding value of node
	 * @param key
	 * @return
	 */
	public String search(String key) 
	{ 
	    BSTNode iterator = null;
	    iterator = this.root;
	    
	    while(iterator != null)
	     {
	    	// if key matched return corresponding value
	    	if (key.equals(iterator.key)) 
	        {
	    	  	return iterator.value;
			}
	    	
	    	// if key  is lesser then iterator key then move to left sub tree
	    	else if (key.compareTo(iterator.key) < 0) 
	        {
	        	iterator = iterator.left;
	        }
	    	
	    	// if key  is greater then iterator key then move to right sub tree
	        else if (key.compareTo(iterator.key) > 0) 
	        {
	        	iterator = iterator.right; 
	        }
	     }
	    if (iterator == null) 
		    	throw new AssertionError(" Word not found");
	    return null;
	} 
	
	/**used to insert node in binary search tree
	 * @param key
	 * @param value
	 */
	void insert(String key, String value ) 
	{ 
		  
        /* If the tree is empty, return a new node */
        if (this.root == null) 
        { 
        	this.root = new BSTNode(key, value); 
        } 
        else
        {
        	BSTNode iterator = null;
        	BSTNode PreIterator = null;
        	iterator = this.root;
        
        	// iterate un-till we found a location to insert the node 
        	while(iterator != null)
        	{
        		PreIterator = iterator;
        		
        		// if key  is lesser then iterator key then move to left sub tree
        		if (key.compareTo(iterator.key) < 0) 
        		{
        			iterator = iterator.left;
        		}
        		
        		// if key  is greater then iterator key then move to right sub tree
        		else if (key.compareTo(root.key) > 0)
        		{
        			iterator = iterator.right; 
        		}
            }
        	
        	if (PreIterator == null)  
        		PreIterator = new BSTNode(key , value);  
            
        	// if key  is lesser than iterator key then assign to the left child
        	
            else if (key.compareTo(PreIterator.key) < 0)  
                PreIterator.left = new BSTNode(key , value);
            
            // else assign the new node to its right child  
            else
            	PreIterator.right = new BSTNode(key , value);;   
        
            	System.out.println(" ======> node added");
        }
     
    } 
	
	/**we use this function to find the in-order successor of the candidate node to be deleted
	 * @param root, the root node of which we find the in-order successor
	 * @return, in-order successor key
	 */
	String findInorderSuccessor(BSTNode currentNode) 
    { 
		currentNode = currentNode.right;
        String inOrderSuccessorKey = currentNode.key; 
        
        while (currentNode.left != null) 
        { 
        	inOrderSuccessorKey = currentNode.left.key; 
            currentNode = currentNode.left;    
        } 
        return inOrderSuccessorKey; 
    } 
    
	
	/**we use this function to delete the node from bst
	 * @param root
	 * @param key
	 * @return 
	 */
	BSTNode delete(BSTNode root, String key) 
    { 
		// if tree is empty 
		if (root == null)  return root; 
		
        if (key.compareTo(root.key) < 0) 
            root.left = delete(root.left, key); 
        else if (key.compareTo(root.key) > 0) 
            root.right = delete(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // Get the in-order successor
            root.key = findInorderSuccessor(root); 
            root.value = search(root.key);
            
            // Delete the in-order successor 
            root.right = delete(root.right, root.key); 
        }  
       return root; 
    }
	
	/** function to in-order traverse the BST and return the sorted values
	 * @param node
	 */
	public BSTLinkedList getSortedValues(BSTNode node) {
		  
		if (node == null) 
            return null; 
	
		getSortedValues(node.left); 
	  
        sortedList.addNode(node.key);
		
		getSortedValues(node.right); 

		return this.sortedList;
	}
	
	/**function to in-order traverse the BST and return the sorted values b/w two keys
	 * @param node, root node
	 * @param key1 
	 * @param key2
	 */
	public BSTLinkedList getSortedValues(BSTNode node, String key1, String key2) {
		  
			if (node == null) 
	            return null; 
			
			// if key is greater than key1 traverse to left
			if(node.key.compareTo(key1) > 0)
			{
			getSortedValues(node.left, key1, key2); 
			}
			
			// if key is in the middle of key1 and key2
			if( (node.key.compareTo(key2) <= 0))
			{
				sortBtKeyList.addNode(node.key);
			}
			
			// if key is lesser than key2 traverse to right
			if( node.key.compareTo(key2) < 0)
			{
			getSortedValues(node.right, key1, key2); 
			}
			
			return this.sortBtKeyList;
	}
	
	public static void main(String[] args) 
	{
		BSTDictionary dict = new BSTDictionary();
		dict.readJsonFile();

		System.out.println(dict.search("TY"));
//		System.out.println(dict.delete(dict.root, "TY").key);
		
		System.out.println();
		BSTLinkedList sortedListByKey = dict.getSortedValues(dict.root, "CO", "RIP");
		BSTLinkedList sortedList = dict.getSortedValues(dict.root);
	
		
		System.out.println("\n\n");
		sortedList.showList();
		System.out.println("\n");
		sortedListByKey.showList();
		
	}


	
}
