package co.grandcircus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MainTaskApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		List<Task> tasks = new ArrayList<>();
		String cont = "yes";

		while (cont.toLowerCase().startsWith("y")) {
			// your code should start here!
			boolean completed = false;
			String name = "";
			String description = "";
			String date = "";
			printTaskMenu();
			int userInput = Validator.getInt(scnr, "What would you like to do? ");
				if(userInput == 1) {
					listTasks(tasks);
				} else if (userInput == 2){
					completed = false;
					date = Validator.getStringMatchingRegex(scnr, "Due Date: ", "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$");
					name = Validator.getString(scnr, "Team Member Name: ");
					description = Validator.getString(scnr, "Task Description: ");
					tasks.add(addTask(completed, date, name, description));
				} else if(userInput == 3) {
					listTasks(tasks);
					int num = Validator.getInt(scnr, "Which task would you like to remove? (enter Task#) ");
					String response = Validator.getString(scnr, "Are you sure (yes/no) ");
					if(response.toLowerCase().startsWith("y")) {
						removeTask(tasks, num);
					} else {
						continue;
					}
				}else if(userInput == 4) {
					listTasks(tasks);
					int num = Validator.getInt(scnr, "Which task would you like to mark complete? (enter Task#) ");
					markComplete(tasks, num);
				}else if(userInput == 5) {
					printNames(tasks);
					String name1 = Validator.getString(scnr, "Which name do you want to search for? ");
					sortList(name1, tasks);
				}
				else if(userInput == 6) {
					break;
				}
			System.out.println("Do you want to continue (yes/no)");
			cont = scnr.nextLine();
		}

		//This is our indication that the program has ended
		System.out.println("Have a great day!");

		scnr.close();
	}
	
	public static void printTaskMenu() {
		
		System.out.println("Welcome to the Task Manager!");
		System.out.printf("\n\t1. %s", "List tasks");
		System.out.printf("\n\t2. %s", "Add task");
		System.out.printf("\n\t3. %s", "Delete task");
		System.out.printf("\n\t4. %s", "Mark task complete");
		System.out.printf("\n\t5. %s", "Search tasks by name");
		System.out.printf("\n\t6. %s", "Quit");
		System.out.println("\n");
	}
	public static void listTasks(List<Task> tasks) {
		System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Task#", "Done?", "Due Date", "Team Member", "Description"); //"Task#%-10s Done?\t Due Date\t Team Member\t Description\t\n"
		int counter = 1;
		for(Task task : tasks) {
			System.out.printf("%-15s %s \n", counter++ + ".", task);
		}
	}
	public static Task addTask(boolean completed, String date, String name, String description) {
		Task task = new Task(completed, date, name, description);
		return task;
	}
	public static void removeTask(List<Task> tasks, int num) {
		tasks.remove(num-1);
	}
	public static void markComplete(List<Task> tasks, int num) {
		tasks.get(num-1).setCompleted(true);
	}
	public static void sortList(String name, List<Task> tasks) {
		System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Task#", "Done?", "Due Date", "Team Member", "Description");
		int counter = 1;
		for(Task task : tasks) {
			if (task.getName().contains(name)) {
				System.out.printf("%-15s %s \n", counter++ + ".", task);
			}
		}
	}
	public static void printNames(List<Task> tasks) {
		Set<String> nameSet = new HashSet<>();
		for(Task task : tasks) {
			nameSet.add(task.getName());
		}
		System.out.println("");
		for(String name3 : nameSet) {
			System.out.printf("%s\n", name3);
		}
		System.out.println("");
	}

}
