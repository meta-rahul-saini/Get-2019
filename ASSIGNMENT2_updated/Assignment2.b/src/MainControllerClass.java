import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainControllerClass {

	static Map<Integer, Process> processesMap = new HashMap<>();

	// display options to the user
	public static void displayOptions() {

		System.out.println("1. completion time of the process");

		System.out.println("2. waiting time of the process");

		System.out.println("3. turn around time of the process");

		System.out.println("4. average waiting time");

		System.out.println("5. max waiting time");

		System.out.println("6. Exit");

	}

	// function to get choice from user

	public static int getChoice() {
		int choice = 0;
		boolean error = true;
		do {
			try {

				System.out.println("Enter your choice:\n");

				Scanner sc = new Scanner(System.in);

				choice = sc.nextInt();

				if (choice < 1 | choice > 6) {
					System.out.println("Please Enter a valid positive integer");
					error = true;
				} else {
					error = false;
					if (choice == 6) {
						System.out.println("Exiting System");
						System.exit(0);
					}
				}

			} catch (InputMismatchException e) {
				System.out
						.println("Input Mismatch Exception occured. Please Enter a valid Positive Integer");
			}

		} while (error == true);

		return choice;
	}

	// get process number

	public static int getProcessID(int noOfProcess) {

		int targetProcessID = 0;
		boolean error = true;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Process ID");
			targetProcessID = sc.nextInt();
			if (targetProcessID > noOfProcess || targetProcessID < 0) {
				System.out.println("Please Enter valid process number b/w" + 0
						+ "and " + noOfProcess);

			} else {
				error = false;
			}
		} while (error == true);
		return targetProcessID;

	}

	public static void main(String[] args) {

		// we create JobScheduler instance to perform schedule the jobs.
		FCFSJobScheduler fcfsJobScheduler = new FCFSJobScheduler();

		int processID = 0;

		System.out.println("Enter no. of process you want to add:\n");
		Scanner sc = new Scanner(System.in);
		int noOfProcess = 0;
		try {
			noOfProcess = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e);
			noOfProcess = 0;
		}

		// these variables holds temporary value for arrivalTime and burstTime
		// of a process

		int arrivalTime = 0;
		int burstTime = 0;

		// getting the arrivalTime and burstTime for each process

		for (int currentProcess = 0; currentProcess < noOfProcess; currentProcess++) {

			// get arrival time from the user

			try {
				System.out.println("Enter Arrival time for process P"
						+ (currentProcess + 1) + ":");
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
		
		// sorting the processMap based on key 
		
		 Map<Integer,Process> sortedProcessesMapMap = new TreeMap<Integer, Process>(processesMap);

		boolean flag = true;
		int choice = 0;
		int targetProcessID = 0;
		while (flag == true) {
			displayOptions();

			choice = getChoice();

			switch (choice) {
			case 1:
				// perform validation
				processID = getProcessID(noOfProcess);
				int completionTime = fcfsJobScheduler.completionTime(
						sortedProcessesMapMap, targetProcessID);

				System.out.println("Comletion time for process: "
						+ targetProcessID + "is :" + completionTime);
				break;

			case 2:
				// perform validation
				processID = getProcessID(noOfProcess);
				int waitingTime = fcfsJobScheduler.waitingTime(sortedProcessesMapMap,
						targetProcessID);
				System.out.println("Waiting time for process: "
						+ targetProcessID + "is :" + waitingTime);
				break;

			case 3:
				System.out.println("Enter process Number");
				// perform validation
				processID = getProcessID(noOfProcess);
				int turnAroundTime = fcfsJobScheduler.turnAroundTime(
						sortedProcessesMapMap, targetProcessID);
				System.out.println("turn around time of process: "
						+ targetProcessID + ": " + turnAroundTime);
				break;

			case 4:
				float averageWaitingTime = fcfsJobScheduler
						.averageWaitingTime(sortedProcessesMapMap);
				System.out.println("Average Waiting time is :"
						+ averageWaitingTime);
				break;

			case 5: 
				int maxWaitingTime = fcfsJobScheduler
						.maxWaitingTime(sortedProcessesMapMap);
				System.out
						.println("Maximum Waiting time is :" + maxWaitingTime);
				break;
			}

		}

		sc.close();

	}

}
