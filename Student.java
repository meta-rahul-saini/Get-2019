
public class Student {
	private String name;
	private int rank;
	private int [] prefProgramList = new int[5];
	private int progId = -1;
	
	Student(String name, int rank, int[] prefProgramList){
		this.name = name;
		this.rank = rank;
		this.prefProgramList = prefProgramList;
	}
	
	String getName(){
		return name;
	}
	int getRank(){
		return rank;
	}
	int[] prefrenceOrder(){
		return prefProgramList;
	}
	void setProgID(int id){
		this.progId = id;
	}
	int programId(){
		return progId;
	}
}
