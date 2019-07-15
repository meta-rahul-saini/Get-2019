import java.util.HashMap;
import java.util.Scanner;

public class FCFSJobScheduler {

	/*
	 * in SCFS completion time is equal to burst time hence we simply return burst
	 * time of each process as its completion time
	 */
	
	public int completionTime(HashMap<Integer, Process> processList, int targetProcessID) {
		
		int completionTime = 0;
		int completionTimeOfPrevProcess = 0;
	
		// arrival time of target process
		int targetArrivalTime = processList.get(targetProcessID).getArrivalTime();
		
		// burst time of target process
		
		int targetBurstTime = processList.get(targetProcessID).getBurstTime();
		
		// check if target process is first process then completion time would be as follow:
		if(targetProcessID==0)
			{
				completionTime = targetArrivalTime + targetBurstTime;
				return completionTime;
			}
		
		// CompletionTime = completionTimeOfPrevProcess + targetBurstTime
		
		else{
				completionTimeOfPrevProcess = completionTime(processList, targetProcessID-1);
				if(completionTimeOfPrevProcess > targetArrivalTime)
				{
					completionTime = completionTimeOfPrevProcess + targetBurstTime;
				}
				else{
					completionTime = targetArrivalTime + targetBurstTime;
				}
				return completionTime;
			}
		
	}

	
	// this function returns the turnAround time for a process.
	
		public int turnAroundTime(HashMap<Integer, Process> processList, int targetProcessID) {

			// arrival time of the target process

			int arrivalTime = processList.get(targetProcessID).getArrivalTime();
			
			// turnAround = completionTime - arrivalTime;
			
			int turnAroundTime = completionTime(processList, targetProcessID) - arrivalTime;
			
			return turnAroundTime;

		}
		
	// this function is used to compute waiting time of a process
	public int waitingTime(HashMap<Integer, Process> processList, int targetProcessID) {


		// waitingTime of the target process
		int burstTime = processList.get(targetProcessID).getBurstTime();
		
		// waitingTime = turnAroundTime - burstTime
		
		int waitingTime = turnAroundTime(processList, targetProcessID) - burstTime;
		
		return waitingTime;

	}
	
	
	
	
	
	
	public float averageWaitingTime(HashMap<Integer, Process> processList)
	{
		int totalWaitingTime = 0;
		int waitingTime = 0;
		
		// computing total waiting time
		
		for (int processID: processList.keySet())
		{
			waitingTime = waitingTime(processList, processID);
			totalWaitingTime += waitingTime;
		}
		
		int totalNoOfProcess = processList.size();
		
		// average waiting time
		
		float avgWaitingTime = totalWaitingTime/totalNoOfProcess;
		
		return avgWaitingTime;
	}
	
	
	public int maxWaitingTime(HashMap<Integer, Process> processList)
	{

		int maxWaitingTime = 0;
		int waitingTime = 0;
		
		// finding maximum waiting time
		
		for (int processID: processList.keySet())
		{
			waitingTime = waitingTime(processList, processID);
			if(waitingTime > maxWaitingTime){
				maxWaitingTime = waitingTime;
			}
		}
		
		return maxWaitingTime;
	}
	

}
