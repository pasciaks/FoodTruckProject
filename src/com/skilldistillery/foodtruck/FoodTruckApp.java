package com.skilldistillery.foodtruck;

import java.util.Scanner;

/*
 * The FoodTruckApp class is the main class for the Food Truck project. It is
 * responsible for the main menu and user interaction.
 */
public class FoodTruckApp {

	private int MAX_TRUCKS = 5;

	private String ANSI_RESET = "\u001B[0m";
	private String ANSI_RED = "\u001B[31m";
	private String ANSI_GREEN = "\u001B[32m";
	private String ANSI_YELLOW = "\u001B[33m";
	private String ANSI_PURPLE = "\u001B[35m";
	private String ANSI_CYAN = "\u001B[36m";

	private FoodTruck[] foodTrucks = new FoodTruck[MAX_TRUCKS];

	/*
	 * The main method is the entry point for the Food Truck App. It creates an
	 * instance of the FoodTruckApp and calls the run method.
	 */
	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();
		app.run();

	}

	public void run() {

		Scanner kb = new Scanner(System.in);

		showWelcome();

		getFoodTruckData(kb);

		interactiveMenu(kb);

		kb.close();

	}

	/*
	 * The getTestFoodTruckData method is used to populate the foodTrucks array with
	 * test data. It is called from the interactiveMenu method.
	 */
	public void getTestFoodTruckData() {
		int addTruckResult = -1;

		System.out.println(ANSI_YELLOW + "\nAdding test data..." + ANSI_RESET);

		addTruckResult = addTruck("Taco Bad Rating", "Mexican", 0); // should fail // 0 rating
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck("No Food Type", null, 5); // should fail // null food type
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck(null, "Mexican No Name", 5); // should fail // null name
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck("", "Mexican No Name", 5); // should fail // short name
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck("Burger Bus", "American", getRandomInt(1, 5));
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck("Pizza Wagon", "Italian", getRandomInt(1, 5));
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck("Sushi Van", "Japanese", getRandomInt(1, 5));
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck("Curry Cart", "Indian", getRandomInt(1, 5));
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck("Fish Friends", "Seafood", getRandomInt(1, 5));
		checkTruckAdded(addTruckResult);

		addTruckResult = addTruck("Bad Too Many", "French", getRandomInt(1, 5)); // should fail (max trucks)
		checkTruckAdded(addTruckResult);

		System.out.println(ANSI_YELLOW + "\n----------------\nTest data added.\n----------------\n" + ANSI_RESET);
		System.out.println(
				ANSI_YELLOW + "Note, some trucks may not have been added due to bad data validation." + ANSI_RESET);
		System.out.println(
				ANSI_YELLOW + "Note, some trucks may not have been added due to truck array being full." + ANSI_RESET);
		System.out.println(
				ANSI_YELLOW + "This was deliberate for test case demonstration of 'backend' validation." + ANSI_RESET);
	}

	/*
	 * The checkTruckAdded method is used to display the result of adding a truck
	 * from the test data method.
	 */
	public void checkTruckAdded(int addTruckResult) {
		if (addTruckResult >= 0) {
			System.out.println("Truck added with TruckID = " + addTruckResult);
		}
	}

	/*
	 * The getIntegerInRange method is used to prompt the user for a number within a
	 * specified range.
	 */
	public int getIntegerInRange(Scanner kb, int min, int max) {

		int input = 0;

		do {
			System.out.print("Enter a number between " + min + " and " + max + ": ");
			try {
				input = Integer.parseInt(kb.nextLine().trim());
			} catch (Exception e) {
				// System.err.println("Error: " + e.getMessage()); // failed to parse as integer
				continue;
			}
		} while (input < min || input > max);
		return input;
	}

	/*
	 * The interactiveMenu method is used to display the main menu and prompt the
	 * user for a selection.
	 */
	public void interactiveMenu(Scanner kb) {

		int selection = 0;

		do {

			displayMenu();

			selection = getIntegerInRange(kb, 1, 6);

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
				break;
			case 5:
				reset();
				break;
			case 6:
				getFoodTruckData(kb);
				break;
			default:
				showInvalidSelection();
				break;

			}

		} while (selection != 4);

	}

	/*
	 * The showWelcome method is used to display a welcome message to the user.
	 */
	public void showWelcome() {
		System.out.println(ANSI_RED + "\nWelcome to the Food Truck App!" + ANSI_RESET);
		System.out.println(ANSI_CYAN + "\nHomework #2 - Skill Distillery" + ANSI_RESET);
	}

	/*
	 * The showGoodbye method is used to display a goodbye message to the user.
	 */
	public void showGoodbye() {
		System.out.println(ANSI_YELLOW + "\n\nGoodbye!\n\n" + ANSI_RESET);
	}

	/*
	 * The showInvalidSelection method is used to display a message to the user when
	 * an invalid selection is made.
	 */
	public void showInvalidSelection() {
		System.out.println("\nInvalid selection. Please try again.");
	}

	/*
	 * The reset method is used to reset the foodTrucks array to its initial state.
	 */
	public void reset() {
		System.out.println(ANSI_RED + "\n\nResetting data..." + ANSI_RESET);
		foodTrucks = new FoodTruck[MAX_TRUCKS];
	}

	/*
	 * The findEmptyslot method is used to find the first empty slot in the
	 * foodTrucks array. It returns the index of the first empty slot or -1 if no
	 * empty slots are found.
	 */
	public int findEmptyslot() {
		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * The getFoodTruckData method is used to prompt the user for data to add a food
	 * truck to the foodTrucks array.
	 * 
	 * It will continue to prompt the user for data until the user enters "quit" or
	 * the foodTrucks array is full.
	 * 
	 * It will also accept the command "data" to auto populate test data.
	 * 
	 */
	public void getFoodTruckData(Scanner kb) {

		String name;
		String foodType;
		int rating;

		int currentTruck = -1;

		do {

			currentTruck = findEmptyslot();

			if (currentTruck < 0) {
				System.err.println("No room for more trucks.");
				break;
			}

			System.out.println("\nFor Truck Spot " + (currentTruck + 1));

			name = getNameOrExitCommand(kb);

			// NOTE: the FoodTruck class will also validate the value for minimum length
			if (name == null) {
				System.err.println("Error adding truck: Name must not be null!");
				continue;
			}

			// NOTE: the FoodTruck class will also validate the value for minimum length
			if (name.length() == 0) { // NOTE: This differs from the FoodTruck class validation
				System.err.println("Error adding truck: Name must be more than 0 chars in length!");
				continue;
			}

			if (name.toLowerCase().equals("data")) {
				getTestFoodTruckData();
				break;
			}

			if (name.toLowerCase().equals("quit")) {
				break;
			}

			// NOTE: the FoodTruck class will also validate the value for minimum length
			foodType = getFoodType(kb);
			if (foodType == null) { // NOTE: This differs from the FoodTruck class validation
				continue;
			}

			// NOTE: the FoodTruck class will also validate the value for minimum length
			if (foodType.length() == 0) { // NOTE: This differs from the FoodTruck class validation
				System.err.println("Error adding truck: Food type must be more than 0 chars in length!");
				continue;
			}

			// front end validation
			rating = getRating(kb);
			if (rating < 1 || rating > 5) {
				continue;
			}

			// back end validation
			if (addTruck(name, foodType, rating) >= 0) {
				currentTruck++;
			} else {
				System.err.println("Error adding truck: Please try again.");
			}

		} while (currentTruck > -1);

	}

	/*
	 * The getNameOrExitCommand method is used to prompt the user for the name of a
	 * food truck or the command "quit" or "data" to stop entering trucks.
	 */
	public String getNameOrExitCommand(Scanner kb) {
		// Initialize local variables
		String name = "";

		// Prompt and get user input
		System.out.println("\nEnter the name of the food truck or " + ANSI_RED + "'quit'" + ANSI_RESET
				+ " to stop entering trucks.");
		System.out.println("Enter the name of the food truck or " + ANSI_RED + "'data'" + ANSI_RESET
				+ " to auto populate test data.");
		System.out.print(ANSI_CYAN + "Enter the name of the food truck: " + ANSI_RESET);

		name = kb.nextLine().trim();

		System.out.println();

		// Validation and return
		if (name == null) {
			System.err.println(ANSI_RED + "Error adding truck: Name must not be null!" + ANSI_RESET);
			return null;
		}

		return name;
	}

	/*
	 * The getFoodType method is used to prompt the user for the type of food served
	 * by a food truck.
	 */
	public String getFoodType(Scanner kb) {
		// Initialize local variables
		String foodType = "";

		// Prompt and get user input
		System.out.print(ANSI_CYAN + "\nEnter the type of food served: " + ANSI_RESET);

		foodType = kb.nextLine().trim();

		// Validation and return
		if (foodType.length() == 0) {
			System.err.println(ANSI_RED + "Error adding truck: Food type must not be null!" + ANSI_RESET);
			return null;
		}

		return foodType;
	}

	/*
	 * The getRating method is used to prompt the user for the rating of a food
	 * truck. A rating must be between 1 and 5.
	 */
	public int getRating(Scanner kb) {
		// Initialize local variables
		int rating = 0;
		String ratingString = "";

		// Prompt and get user input
		System.out.println("\n1 - Terrible, 2 - Bad, 3 - Average, 4 - Good, 5 - Excellent");
		System.out.print(ANSI_CYAN + "Enter the rating for this truck " + ANSI_GREEN + "(1-5)" + ANSI_RESET + ": ");

		ratingString = kb.nextLine().trim();

		// Validation and return
		try {
			rating = Integer.parseInt(ratingString);
			if (rating < 1 || rating > 5) {
				throw new IllegalArgumentException("Rating must be between 1 and 5!");
			}
		} catch (Exception e) {
			System.err
					.println(ANSI_RED + "Error adding truck: Not a Valid Rating (" + e.getMessage() + ")" + ANSI_RESET);
			rating = 0;
		}

		return rating;
	}

	/*
	 * The addTruck method is used to add a food truck to the foodTrucks array. It
	 * will return the truckID of the truck added or -1 if the truck was not added.
	 */
	public int addTruck(String name, String foodType, int rating) {

		for (int i = 0; i < foodTrucks.length; i++) {

			if (foodTrucks[i] == null) {
				FoodTruck ft = null;
				try {
					// NOTE: In this try/catch, a failed constructor will throw an exception
					// NOTE: This implements a 'sort-of' back-end validation
					ft = new FoodTruck(name, foodType, rating);
				} catch (Exception e) {
					System.err.println("Error adding truck: " + e.getMessage());
					return -1;
				}
				foodTrucks[i] = ft;
				// NOTE: This method will identify a successful add by returning the truckID
				// Rather than returning a boolean true or false, and rather than returning the
				// index where the truck was added
				return ft.getTruckID();
			}

		}

		System.err.println("Error adding truck: No room for more trucks.");
		return -1;

	}

	public void listTrucks() {

		System.out.println("\n" + ANSI_RED + "All trucks:" + ANSI_RESET);
		int countOfTrucks = 0;
		for (FoodTruck ftCurrent : foodTrucks) {
			if (ftCurrent != null) {
				System.out.println(ANSI_YELLOW + ftCurrent + ANSI_YELLOW);
				countOfTrucks++;
			}
		}
		if (countOfTrucks == 0) {
			System.out.println(ANSI_RED + "No trucks to display." + ANSI_RESET);
		}
	}

	public void averageRating() {

		listTrucks();

		System.out.println("\n" + ANSI_RED + "Average rating:" + ANSI_RESET);
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
			System.out.printf(ANSI_YELLOW + "The average rating of all trucks is %.2f" + ANSI_RESET, average);
		} else {
			average = 0;
			System.out.println(ANSI_RED + "No trucks to average." + ANSI_RESET);
		}
	}

	public void highestRated() {

		listTrucks();

		System.out.println("\n" + ANSI_RED + "Highest-rated truck:" + ANSI_RESET);
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
			System.out.println(ANSI_RED + "No trucks to display." + ANSI_RESET);
		} else {
			System.out.println(ANSI_CYAN + "The (1st) highest-rated truck is: " + ANSI_YELLOW);
			System.out.println(highestRatedFoodTruck + ANSI_RESET);
		}
	}

	public void displayMenu() {

		System.out.println("\n" + ANSI_RED + "Please choose from the following options:" + ANSI_RESET);

		String[] menuChoices = { "List all existing food trucks", "See the average rating of food trucks",
				"Display the highest-rated food truck", "Quit the program", "Reset Data", "Add Food Truck Data" };

		for (int i = 0; i < menuChoices.length; i++) {
			System.out.println(ANSI_GREEN + (i + 1) + ". " + ANSI_PURPLE + menuChoices[i] + ANSI_RESET);
		}

	}

	/*
	 * The getRandomInt method is used to generate a random integer within a
	 * specified range. It is used to populate test data.
	 */
	public int getRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

}
