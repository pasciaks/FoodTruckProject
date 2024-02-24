package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	private int MAX_TRUCKS = 5;

	private FoodTruck[] foodTrucks = new FoodTruck[MAX_TRUCKS];

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();
		app.run();

	}

	public void run() {

		Scanner kb = new Scanner(System.in);

		showWelcome();

		getFoodTruckData(kb);

		// getTestFoodTruckData();

		interactiveMenu(kb);

		kb.close();

	}

	public void getTestFoodTruckData() {
		addTruck("Taco Bad Rating", "Mexican", 0);
		addTruck("No Food Type", null, 5);
		addTruck(null, "Mexican No Name", 5);
		addTruck("Burger Bus", "American", getRandomInt(1, 5));
		addTruck("Pizza Wagon", "Italian", getRandomInt(1, 5));
		addTruck("Sushi Van", "Japanese", getRandomInt(1, 5));
		addTruck("Curry Cart", "Indian", getRandomInt(1, 5));
		addTruck("Fish Friends", "Seafood", getRandomInt(1, 5));
		addTruck("Bad Too Many", "French", getRandomInt(1, 5));
	}

	public void interactiveMenu(Scanner kb) {

		do {

			displayMenu();

			// NOTE: Could be improved with input validation and error handling
			System.out.println("\nEnter a selection: ");
			int selection = kb.nextInt();
			kb.nextLine();

			switch (selection) {
			case 1:
				listTrucks();
				break;
			case 2:
				averageRating();
				break;
			case 3:
				highestRated();
				break;
			case 4:
				showGoodbye();
				return;
			default:
				System.out.println("\nInvalid selection. Please try again.");
				break;
			}

		} while (true);

	}

	public void showWelcome() {
		System.out.println("\nWelcome to the Food Truck App!\n");
	}

	public void showGoodbye() {
		System.out.println("\n\nGoodbye!\n\n");
	}

	public void getFoodTruckData(Scanner kb) {

		String name;
		String foodType;
		int rating;

		// for (int i = 0; i < foodTrucks.length; i++) { // NOTE: Re factored

		int currentTruck = 0;

		do {

			System.out.println();
			System.out.println("Truck " + (currentTruck + 1) + " of " + MAX_TRUCKS);

			System.out.println("Enter the name of the food truck or 'quit' to stop entering trucks: ");
			System.out.print("Enter the name of the food truck: ");
			name = kb.nextLine().trim();

			if (name.equals("quit")) {
				break;
			}

			System.out.print("Enter the type of food served: ");
			foodType = kb.nextLine().trim();

			System.out.println();
			System.out.println("1 - Terrible, 2 - Bad, 3 - Average, 4 - Good, 5 - Excellent");
			System.out.print("Enter the rating for this truck (1-5): ");

			String ratingString = kb.nextLine().trim();

			// front end validation
			try {
				rating = Integer.parseInt(ratingString);
				if (rating < 1 || rating > 5) {
					throw new IllegalArgumentException("Rating must be between 1 and 5!");
				}
			} catch (Exception e) {
				System.err.println("Error adding truck: " + e.getMessage());
				continue;
			}

			// back end validation
			if (addTruck(name, foodType, rating)) {
				currentTruck++;
			} else {
				System.err.println("Error adding truck: Please try again.");
			}

		} while (currentTruck < MAX_TRUCKS);

		// } // NOTE: Re factored

	}

	public boolean addTruck(String name, String foodType, int rating) {
		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] == null) {
				FoodTruck ft = null;
				try {
					ft = new FoodTruck(name, foodType, rating);
				} catch (Exception e) {
					System.err.println("Error adding truck: " + e.getMessage());
					return false;
				}
				foodTrucks[i] = ft;
				return true;
			}
		}
		System.err.println("Error adding truck: No room for more trucks.");
		return false;

	}

	public void listTrucks() {
		int countOfTrucks = 0;
		for (FoodTruck ftCurrent : foodTrucks) {
			if (ftCurrent != null) {
				System.out.println(ftCurrent);
				countOfTrucks++;
			}
		}
		if (countOfTrucks == 0) {
			System.out.println("No trucks to display.");
		}
	}

	public void averageRating() {
		int sum = 0;
		int count = 0;
		double average;
		for (FoodTruck ftCurrent : foodTrucks) {
			if (ftCurrent != null) {
				count++;
				sum += ftCurrent.getRating();
			}
		}
		if (count > 0) {
			average = (double) sum / (double) count;
			System.out.printf("The average rating of all trucks is %.2f", average);
		} else {
			average = 0;
			System.out.println("No trucks to average.");
		}
	}

	public void highestRated() {
		FoodTruck highestRatedFoodTruck = null;
		for (FoodTruck ftCurrent : foodTrucks) {
			if (ftCurrent != null) {
				if (highestRatedFoodTruck == null) {
					highestRatedFoodTruck = ftCurrent;
				} else if (ftCurrent.getRating() > highestRatedFoodTruck.getRating()) {
					highestRatedFoodTruck = ftCurrent;
				}
			}
		}
		if (highestRatedFoodTruck == null) {
			System.out.println("No trucks to display.");
		} else {
			System.out.println("The highest-rated truck is: ");
			System.out.println(highestRatedFoodTruck);
		}
	}

	public void displayMenu() {
		System.out.println("");
		System.out.println("1. List all existing food trucks");
		System.out.println("2. See the average rating of food trucks");
		System.out.println("3. Display the highest-rated food truck");
		System.out.println("4. Quit the program");
	}

	public int getRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

}
