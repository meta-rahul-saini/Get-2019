import java.util.HashMap;
import java.util.Scanner;

public class MainControllerClass {

	static HashMap<Integer, Process> processList = new HashMap<>();

	public static void main(String[] args) {
		
		JobScheduler jobScheduler = new JobScheduler();

		System.out.println("Enter no. of process you want to add:\n");
		Scanner sc = new Scanner(System.in);
		int noOfProcess = sc.nextInt();
		int arrivalTime = 0;
		int burstTime = 0;
		for (int i = 0; i < noOfProcess; i++) {
			System.out.println("Enter Arrival time for process P" + (i + 1) + ":");
			Scanner sc1 = new Scanner(System.in);
			arrivalTime = sc1.nextInt();

			System.out.println("Enter Burst time for process P" + (i + 1) + ":");
			Scanner sc2 = new Scanner(System.in);
			burstTime = sc2.nextInt();

			Process p = new Process();
			p.setArrivalTime(arrivalTime);
			p.setBurstTime(burstTime);

			processList.put(i, p);
		}

		System.out.println("=================");
		System.out.println("WaitingTime for Process P2 " + jobScheduler.waitingTime(processList, 2));

	}
	
}
