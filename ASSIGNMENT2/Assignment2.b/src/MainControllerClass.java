import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainControllerClass {

	/**
	 * return the process id for which user wants to find the specifications
	 * 
	 * @param noOfProcess
	 *            , no. of processes are in the system
	 * @return returns process id
	 */
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
		boolean error = true;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int choice = 0;
		int noOfProcess = 0;
		int completionTime = 0;
		int waitingTime = 0;
		int turnAroundTime = 0;
		float averageWaitingTime = 0;

		// input jobs data
		fcfsJobScheduler.inputData();

		// get no of process
		noOfProcess = fcfsJobScheduler.getNoOfProcess();

		while (flag == true) {

			// show options

			System.out.println("1. completion time of the process");

			System.out.println("2. waiting time of the process");

			System.out.println("3. turn around time of the process");

			System.out.println("4. average waiting time");

			System.out.println("5. max waiting time");

			System.out.println("6. Exit");

			// get choice from user
			error = true;
			do {
				try {

					System.out.println("Enter your choice:\n");
					sc = new Scanner(System.in);
					choice = sc.nextInt();
					if (choice < 1 | choice > 6) {
						System.out
								.println("Please Enter a valid positive integer");
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

			switch (choice) {
			case 1:
				processID = getProcessID(noOfProcess);
				completionTime = fcfsJobScheduler.completionTime(processID);
				System.out.println("Comletion time for process: " + processID
						+ "is :" + completionTime);
				break;

			case 2:
				processID = getProcessID(noOfProcess);
				waitingTime = fcfsJobScheduler.waitingTime(processID);
				System.out.println("Waiting time for process: " + processID
						+ "is :" + waitingTime);
				break;

			case 3:
				processID = getProcessID(noOfProcess);
				turnAroundTime = fcfsJobScheduler.turnAroundTime(processID);
				System.out.println("turn around time of process: " + processID
						+ ": " + turnAroundTime);
				break;

			case 4:
				averageWaitingTime = fcfsJobScheduler.averageWaitingTime();
				System.out.println("Average Waiting time is :"
						+ averageWaitingTime);
				break;

			case 5:
				int maxWaitingTime = fcfsJobScheduler.maxWaitingTime();
				System.out
						.println("Maximum Waiting time is :" + maxWaitingTime);
				break;
			}

		}

		sc.close();

	}

}
