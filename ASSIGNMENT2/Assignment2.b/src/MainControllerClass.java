import java.util.HashMap;
import java.util.Scanner;

public class MainControllerClass {

	static HashMap<Integer, Process> processList = new HashMap<>();

	// display options to the user
	public static void displayOptions() {

		System.out.println("1. completion time of the process");

		System.out.println("2. waiting time of the process");

		System.out.println("3. turn around time of the process");

		System.out.println("4. average waiting time");

		System.out.println("5. max waiting time");

		System.out.println("6. Exit");

	}

	
	public static void main(String[] args) {

		// we create JobScheduler instance to perform schedule the jobs.
		FCFSJobScheduler fcfsJobScheduler = new FCFSJobScheduler();

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

		for (int i = 0; i < noOfProcess; i++) {

			// get arrival time from the user

			try {
				System.out.println("Enter Arrival time for process P" + (i + 1)
						+ ":");
				arrivalTime = sc.nextInt();
				if (arrivalTime < 0)
					throw new Exception("Please Enter Positive Integer value");
			} catch (Exception e) {

				System.out.println(e);
				System.out.println("Please Enter Positive Integer value");
				break;
			}

			// get burst time from the user

			try {
				System.out.println("Enter burst time for process P" + (i + 1)
						+ ":");
				burstTime = sc.nextInt();
				if (arrivalTime < 0)
					throw new Exception("Please Enter Positive Integer value");
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Please Enter Positive Integer value");
				break;
			}

			// create a new process instance and set arrival time and burst time
			// then add into processList

			Process p = new Process();
			p.setArrivalTime(arrivalTime);
			p.setBurstTime(burstTime);

			processList.put(i, p);
		}

		boolean flag = true;
		int choice = 0;
		int targetProcessID = 0;
		while (flag == true) {
			displayOptions();
			System.out.println("Enter your choice:\n");
			try {
				choice = sc.nextInt();
				if (choice > 5 || choice < 0) {
					throw new Exception("please enter valid choice");
				}
			} catch (Exception e) {
				System.out
						.println("Please Enter a valid Positve Integer choice");
			}

			switch (choice) {
			case 1: {
				System.out.println("Enter process Number");
				try {
					targetProcessID = sc.nextInt();
					if (targetProcessID > noOfProcess || targetProcessID < 0) {
						System.out
								.println("Please Enter valid process number b/w"
										+ 0 + "and " + noOfProcess);
					}
				} catch (Exception e) {
					System.out.println("Please Enter valid processID");
				}

				int completionTime = fcfsJobScheduler.completionTime(
						processList, targetProcessID);

				System.out.println("Comletion time for process: "
						+ targetProcessID + "is :" + completionTime);
				break;

			}

			case 2: {
				System.out.println("Enter process Number");
				try {
					targetProcessID = sc.nextInt();
					if (targetProcessID > noOfProcess || targetProcessID < 0) {
						System.out
								.println("Please Enter valid process number b/w"
										+ 0 + "and " + noOfProcess);
					}
				} catch (Exception e) {
					System.out.println("Please Enter valid processID");
				}

				int waitingTime = fcfsJobScheduler.waitingTime(processList,
						targetProcessID);

				System.out.println("Waiting time for process: "
						+ targetProcessID + "is :" + waitingTime);
				break;
			}

			case 3: {
				System.out.println("Enter process Number");
				try {
					targetProcessID = sc.nextInt();
					if (targetProcessID > noOfProcess || targetProcessID < 0) {
						System.out
								.println("Please Enter valid process number b/w"
										+ 0 + "and " + noOfProcess);
					}
				} catch (Exception e) {
					System.out.println("Please Enter valid processID");
				}

				int turnAroundTime = fcfsJobScheduler.turnAroundTime(
						processList, targetProcessID);

				System.out.println("turn around time of process: "
						+ targetProcessID + ": " + turnAroundTime);
				
				break;
			}

			case 4: {

				float averageWaitingTime = fcfsJobScheduler
						.averageWaitingTime(processList);

				System.out.println("Average Waiting time is :"
						+ averageWaitingTime);
				break;
			}

			case 5: {

				int maxWaitingTime = fcfsJobScheduler
						.maxWaitingTime(processList);

				System.out
						.println("Maximum Waiting time is :" + maxWaitingTime);
				break;

			}
			}

		}

		sc.close();

	}

}
