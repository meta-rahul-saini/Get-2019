
public class Program {
	private String programName;
	private int programId;
	private int programCapacity;
	
	Program(String programName, int id, int capacity)
	{
		this.programName = programName;
		this.programId = id;
		this.programCapacity  = capacity;
	}
	
	String getProgramName()
	{
		return programName;
	}
	
	int getProgramId(){
		return programId;
	}
	
	int getProgramCapacity()
	{
		return programCapacity;
	}
	
	boolean isAvailable(){
		
		if(this.programCapacity > 0)
		{
			return true;
		}
		return false;
	}
	
	public void setProgramCapacity(int capacity)
	{
		this.programCapacity = capacity - 1 ;
	}
}
