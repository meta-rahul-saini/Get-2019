import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FCFSJobScheduler {

	/*
	 * in SCFS completion time is equal to burst time hence we simply return burst
	 * time of each process as its completion time
	 */
	
	public int completionTime(Map<Integer, Process> processesMap, int targetProcessID) {
		
		int completionTime = 0;
		int completionTimeOfPrevProcess = 0;
	
		// arrival time of target process
		int targetArrivalTime = processesMap.get(targetProcessID).getArrivalTime();
		
		// burst time of target process
		
		int targetBurstTime = processesMap.get(targetProcessID).getBurstTime();
		
		// check if target process is first process then completion time would be as follow:
		if(targetProcessID==0)
			{
				completionTime = targetArrivalTime + targetBurstTime;
				return completionTime;
			}
		
		// CompletionTime = completionTimeOfPrevProcess + targetBurstTime
		
		else{
				completionTimeOfPrevProcess = completionTime(processesMap, targetProcessID-1);
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
	
		public int turnAroundTime(Map<Integer, Process> processesMap, int targetProcessID) {

			// arrival time of the target process

			int arrivalTime = processesMap.get(targetProcessID).getArrivalTime();
			
			// turnAround = completionTime - arrivalTime;
			
			int turnAroundTime = completionTime(processesMap, targetProcessID) - arrivalTime;
			
			return turnAroundTime;

		}
		
	// this function is used to compute waiting time of a process
	public int waitingTime(Map<Integer, Process> processesMap, int targetProcessID) {


		// waitingTime of the target process
		int burstTime = processesMap.get(targetProcessID).getBurstTime();
		
		// waitingTime = turnAroundTime - burstTime
		
		int waitingTime = turnAroundTime(processesMap, targetProcessID) - burstTime;
		
		return waitingTime;

	}
	
	
	
	
	
	
	public float averageWaitingTime(Map<Integer, Process> processesMap)
	{
		int totalWaitingTime = 0;
		int waitingTime = 0;
		
		// computing total waiting time
		
		for (int processID: processesMap.keySet())
		{
			waitingTime = waitingTime(processesMap, processID);
			totalWaitingTime += waitingTime;
		}
		
		int totalNoOfProcess = processesMap.size();
		
		// average waiting time
		
		float avgWaitingTime = totalWaitingTime/totalNoOfProcess;
		
		return avgWaitingTime;
	}
	
	
	public int maxWaitingTime(Map<Integer, Process> processesMap)
	{

		int maxWaitingTime = 0;
		int waitingTime = 0;
		
		// finding maximum waiting time
		
		for (int processID: processesMap.keySet())
		{
			waitingTime = waitingTime(processesMap, processID);
			if(waitingTime > maxWaitingTime){
				maxWaitingTime = waitingTime;
			}
		}
		
		return maxWaitingTime;
	}
	

}
