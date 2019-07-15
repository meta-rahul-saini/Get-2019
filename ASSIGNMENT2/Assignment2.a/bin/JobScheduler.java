import java.util.HashMap;
import java.util.Scanner;

public class JobScheduler {

	/*
	 * in SCFS completion time is equal to burst time hence we simply return burst
	 * time of each process as its completion time
	 */
	
	public int completionTime(HashMap<Integer, Process> processList, int targetProcessID) {
		int completionTime = processList.get(targetProcessID).getBurstTime();

		return completionTime;
	}

	// this function is used to compute waiting time of a process
	public int waitingTime(HashMap<Integer, Process> processList, int targetProcessID) {

		// calculating cumulative sum of time taken by previous process.

		int cumSumCTPrev = 0;
		int processID = 0;
		while (processID != targetProcessID) {

			cumSumCTPrev += processList.get(i).getArrivalTime() + processList.get(processID).getBurstTime();
			processID++;
		}

		/*
		 * if arrival time of process is greater than above cumulative sum return 0
		 * otherwise return difference of them
		 */

		int arrivalTime = processList.get(processID).getArrivalTime();

		if (arrivalTime > cumSumCTPrev)
			return 0;
		else
			return Math.abs((cumSumCTPrev - arrivalTime));

	}
	
	
	// this function returns the turnAround time for a process.
	
	public int turnAroundTime(HashMap<Integer, Process> processList, int targetProcessID) {

		// calculating cumulative sum of time taken by previous process.

		int cumSumCTPrev = 0;
		int processID = 0;
		while (processID != targetProcessID) {

			cumSumCTPrev += processList.get(processID).getArrivalTime() + processList.get(processID).getBurstTime();
			processID++;
		}

		/*
		 * if arrival time of process is greater than above cumulative sum return 0
		 * otherwise return difference of them
		 */

		int arrivalTime = processList.get(processID).getArrivalTime();

		int burstTime = processList.get(processID).getBurstTime();
		if (arrivalTime > cumSumCTPrev)
			return 0 + burstTime;
		else
			return Math.abs((cumSumCTPrev - arrivalTime)) + burstTime;

	}
	
	
	public float averageWaitingTime(HashMap<Integer, Process> processList)
	{
		int totalWaitingTime = 0;
		int cumSumCTPrev = 0;
		
		for (int processID1: processList.keySet())
		{
			cumSumCTPrev = 0;
			for (int processID2=0; processID2<=processID1; processID2++)
			{
			
				cumSumCTPrev += processList.get(processID1).getArrivalTime() + processList.get(processID1).getBurstTime();				
			
			}
			totalWaitingTime += cumSumCTPrev;
		}
		
		int totalNoOfProcess = processList.size();
		float avgWaitingTime = totalWaitingTime/totalNoOfProcess;
		
		return avgWaitingTime;
	}
	
	
	public float maxWaitingTime(HashMap<Integer, Process> processList)
	{
		int totalWaitingTime = 0;
		int cumSumCTPrev = 0;
		int maxWaitingTime = 0;
		
		for (int processID1: processList.keySet())
		{
			cumSumCTPrev = 0;
			for (int processID2=0; processID2<=processID1; processID2++)
			{
			
				cumSumCTPrev += processList.get(processID1).getArrivalTime() + processList.get(processID1).getBurstTime();				
			
			}
			if(cumSumCTPrev > maxWaitingTime)
			{
				maxWaitingTime = cumSumCTPrev;
			}
		}
		
		return maxWaitingTime;
	}
	

}
