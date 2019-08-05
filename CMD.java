import java.util.Scanner;

public class CMD {

	TreeNode root = new TreeNode("root");
	TreeNode currentDirectory = this.root;
	String prompt = "root";

	/** function to create directory in the currentDirectory
	 * @param directoryName, directory name passed by user
	 * @return, true if directory is created, AssertionError is thrown if folder already exists
	 */
	public boolean mkdir(String directoryName) 
	{
		Node childIterator = null;

			System.out.println("front: " + currentDirectory.childNodes.getFront() );
			childIterator = currentDirectory.childNodes.getFront();

			// if we already have directory with the same name
			while (childIterator != null) 
			{
				// if we already have given directory then we throw assertionError 
				if (childIterator.getData().getNodeName().equals(directoryName)) 
				{
					throw new AssertionError("Directory already exists");
				}
				
				childIterator = childIterator.next;
			}
			
			// if we don't have directory with the given name
			TreeNode treeNode = new TreeNode(directoryName);
			
			// setting the parent directory of child node to current directory
			treeNode.parentNode = this.currentDirectory;
			
			// adding created directory to child nodes list
			this.currentDirectory.childNodes.addNode(treeNode);
			
			System.out.println("node added successfully");
			
			return true;
		}

	/**function used to change the currentDirectory to specified directory
	 * @param directoryPath, path of directory
	 * @return true, if directory changed successfully, if user specified any wrong path AssertionError is thrown
	 */
	public boolean cd(String directoryPath) 
	{
		if (directoryPath.equals("..")) 
		{
			if (this.currentDirectory != null && this.root != currentDirectory) 
			{
				// moving to parent directory
				currentDirectory = currentDirectory.parentNode;
				String pathArray[] = this.prompt.split("/");
				
				// update the command prompt
				prompt = "";
				for (int index = 0; index < pathArray.length - 1 ; index++) {
					prompt += pathArray[0];
				}
				return true;
			}
		} 
		else 
		{
			String directoryArray[] = directoryPath.split("/");
			
			Node currentChildIterator = null;
			
			TreeNode changedDirectoryNode = null;
			boolean flag = false;
			
			for (int directoryIndex = 0; directoryIndex < directoryArray.length; directoryIndex++) 
			{
				currentChildIterator = this.currentDirectory.childNodes.getFront();
				

				while (currentChildIterator != null) 
				{
					
					changedDirectoryNode = currentChildIterator.getData();
					
					if (changedDirectoryNode.getNodeName().equals(directoryArray[directoryIndex])) 
					{
						prompt = prompt + "/" + changedDirectoryNode.getNodeName();
						flag = true;
						break;
					}
					currentChildIterator = currentChildIterator.next;
				}
				if (flag == false) 
				{
					throw new AssertionError("given path doesn't exists");
				}

			}
			
			// change the current directory to specified directory
			
			this.currentDirectory = changedDirectoryNode;
		}
		return true;
	}

	
	/**function used to move to parent directory
	 * @return, true if we successfully moved to parent o/w AssertionError is thrown if we are already in root directory
	 */
	public boolean bk() 
	{
		
		if (currentDirectory != null && this.root != currentDirectory) 
		{
			currentDirectory = currentDirectory.parentNode;
			// update the command prompt
			String pathArray[] = prompt.split("/");
			prompt = "";
			for (int index = 0; index < pathArray.length - 1 ; index++) {
				prompt += pathArray[0];
			}
			return true;
		
		} else {
			throw new AssertionError("already in root directory");
		}
	}

	
	/**Display list of all folders in the current folder along with their date-time of creation. 
	 * It also displays total sub folders (1st level only) present in the current directory.
	 * @return AssertionError is thrown if current directory is empty o/w true is returned;
	 */
	public void ls() 
	{
		Node currentChildIterator = this.currentDirectory.childNodes.getFront();
		
		TreeNode currentNode = null;
		
		int totalDirectory = 0;

		if (currentChildIterator == null) 
		{
			throw new AssertionError("current directory is empty");
		}
		
		while (currentChildIterator != null) 
		{
			// getting the child node
			currentNode = currentChildIterator.getData();
		
			// display the directory node and date 
			System.out.println("directory name: " + currentNode.getNodeName()
					+ "\t\t" + "date created: " + currentNode.getDate());
			totalDirectory++;
			currentChildIterator = currentChildIterator.next;
		}
		
		System.out.println("total no. of sub direactorys are: "
				+ totalDirectory);
	}
	
	
	/**Find a folder in current or sub folders (recursively)
	 * @param currentDirectory, current directory in which user is present
	 * @param directoryPath, path
	 * @return true if user specified directory in subfolders is found o/w false is returned
	 */
	public String find(TreeNode currentDirectory, String directoryName)
	{
		if(currentDirectory.getNodeName().equals(directoryName))
			{
			return directoryName;
			}
		
		else
		{
			Node childIterator = currentDirectory.childNodes.getFront();
			
			while(childIterator != null)
			{
				String result = find(childIterator.getData(), directoryName);
	
				if(!result.equals(""))
				{
					return currentDirectory.getNodeName() + "/" + result;
				}
				childIterator = childIterator.next;
			}
		}
		return ""; 
	}
	
	/**Find a folder in current or sub folders (recursively)
	 * @param currentDirectory, current directory in which user is present
	 * @param directoryPath, path
	 * @return true if user specified directory in subfolders is found o/w false is returned
	 */
	public String tree(TreeNode currentDirectory)
	{
			Node childIterator = currentDirectory.childNodes.getFront();
			
			while(childIterator != null)
			{
				System.out.print(" : " + childIterator.getData().getNodeName());
				tree(childIterator.getData());
				System.out.println("");
				childIterator = childIterator.next;
			}
		return ""; 
	}
	
	
	public static void main(String... args) {

		CMD cmd = new CMD();

		
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.printf(cmd.prompt + ">>");
			String cmdTerms[] = sc.nextLine().split("\\s");
			
			switch(cmdTerms[0])
			{
			case "mkdir": cmd.mkdir(cmdTerms[1]);
			break;
			
			case "cd": 	cmd.cd(cmdTerms[1]);
			break;
			
			case "bk": cmd.bk();
			break;
			
			case "ls": cmd.ls();
			break;
			
			case "find": System.out.println(cmd.find(cmd.root, cmdTerms[1]));
			break;
			
			case "tree": cmd.tree(cmd.root);
			break;
			
			}
			
		}while(exit == false);
		sc.close();
	}

}
