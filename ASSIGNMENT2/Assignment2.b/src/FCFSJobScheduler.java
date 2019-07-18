import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FCFSJobScheduler {

	private static Map<Integer, Process> processesMap;
	private int noOfProcess = 0;
	
	/**
	 * this function takes input for JobScheduler like noOfProcess, Process Arrival
	 * Time, Burst Time.
	 */
	public void inputData() {
		int arrivalTime = 0;
		int burstTime = 0;
		Scanner sc ;
		boolean flag = true;
		
		// initialize processes map
		processesMap = new HashMap<>();
		
		// input no. of processes
		flag = true;
		do {
			System.out.println("Enter no. of process you want to add:\n");
			try {
				sc = new Scanner(System.in);
				noOfProcess = sc.nextInt();
				if (noOfProcess < 0) {
					System.out.println("Please Enter a valid positive integer");
				} else {
					flag = false;
				}
			} catch (Exception e) {
				System.out.println(e);
				noOfProcess = 0;
			}
		} while (flag == true);

		// input Arrival Time and Burst Time for each process
		for (int currentProcess = 0; currentProcess < noOfProcess; currentProcess++) {

			try {
				System.out.println("Enter Arrival time for process P"
						+ (currentProcess + 1) + ":");
				sc = new Scanner(System.in);
				arrivalTime = sc.nextInt();
				if (arrivalTime < 0)
					throw new Exception("Please Enter Positive Integer value");
			} catch (Exception e) {

				System.out.println(e);
				System.out.println("Please Enter Positive Integer value");
				currentProcess--;
				continue;
			}

			// get burst time from the user

			try {
				System.out.println("Enter burst time for process P"
						+ (currentProcess + 1) + ":");
				sc = new Scanner(System.in);
				burstTime = sc.nextInt();
				if (arrivalTime < 0)
					throw new Exception("Please Enter Positive Integer value");
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Please Enter Positive Integer value");
				currentProcess--;
				continue;

			}

			// create a new process instance and set arrival time and burst time
			// then add into processesMap

			Process p = new Process();
			p.setArrivalTime(arrivalTime);
			p.setBurstTime(burstTime);

			processesMap.put(currentProcess, p);
		}
	}

	
	/**
	 * we use this to return completion time of a process
	 * 
	 * @param processID,
	 *            processID of process for which we want to find completion time
	 * @return completionTime, requires that if process is first process then it
	 *         return process burst time o/w returns process completion time
	 */
	public int completionTime(
			int targetProcessID) {

		int completionTime = 0;
		int completionTimeOfPrevProcess = 0;

		// arrival time of target process
		int targetArrivalTime = processesMap.get(targetProcessID)
				.getArrivalTime();

		// burst time of target process

		int targetBurstTime = processesMap.get(targetProcessID).getBurstTime();

		// check if target process is first process then completion time would
		// be as follow:
		if (targetProcessID == 0) {
			completionTime = targetArrivalTime + targetBurstTime;
			return completionTime;
		}

		// CompletionTime = completionTimeOfPrevProcess + targetBurstTime

		else {
			completionTimeOfPrevProcess = completionTime(
					targetProcessID - 1);
			if (completionTimeOfPrevProcess > targetArrivalTime) {
				completionTime = completionTimeOfPrevProcess + targetBurstTime;
			} else {
				completionTime = targetArrivalTime + targetBurstTime;
			}
			return completionTime;
		}

	}

	/**
	 * this function returns turn around time of a process, given the processID
	 * 
	 * @param processID,
	 *            processId for which we want to find turn around time
	 * @return turnAroundTime
	 */
	public int turnAroundTime(
			int targetProcessID) {

		// arrival time of the target process

		int arrivalTime = processesMap.get(targetProcessID).getArrivalTime();

		// turnAround = completionTime - arrivalTime;

		int turnAroundTime = completionTime(targetProcessID)
				- arrivalTime;

		return turnAroundTime;

	}

	/**
	 * this function returns turn waiting time of a process, given the processID
	 * 
	 * @param processID,
	 *            processId for which we want to find turn waiting time
	 * @return waitingTime
	 */
	public int waitingTime(
			int targetProcessID) {

		// waitingTime of the target process
		int burstTime = processesMap.get(targetProcessID).getBurstTime();

		// waitingTime = turnAroundTime - burstTime

		int waitingTime = turnAroundTime(targetProcessID)
				- burstTime;

		return waitingTime;

	}

	/**
	 * returns average waiting time of total processes
	 * 
	 * @return float average waiting time
	 */
	public float averageWaitingTime() {
		int totalWaitingTime = 0;
		int waitingTime = 0;

		// computing total waiting time

		for (int processID : processesMap.keySet()) {
			waitingTime = waitingTime(processID);
			totalWaitingTime += waitingTime;
		}

		int totalNoOfProcess = processesMap.size();

		// average waiting time

		float avgWaitingTime = totalWaitingTime / totalNoOfProcess;

		return avgWaitingTime;
	}


	/**
	 * @return, returns maximum waiting time
	 */
	public int maxWaitingTime() {

		int maxWaitingTime = 0;
		int waitingTime = 0;

		// finding maximum waiting time

		for (int processID : processesMap.keySet()) {
			waitingTime = waitingTime(processID);
			if (waitingTime > maxWaitingTime) {
				maxWaitingTime = waitingTime;
			}
		}

		return maxWaitingTime;
	}
	

	// getters and setters 
	
	public static Map<Integer, Process> getProcessesMap() {
		return processesMap;
	}

	public static void setProcessesMap(Map<Integer, Process> processesMap) {
		FCFSJobScheduler.processesMap = processesMap;
	}

	public int getNoOfProcess() {
		return noOfProcess;
	}

	public void setNoOfProcess(int noOfProcess) {
		this.noOfProcess = noOfProcess;
	}

}
