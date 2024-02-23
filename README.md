# FoodTruckProject

#### Description

- This is the 2nd week homework assignment for Skill Distillery, Full Stack Development.


- Users will input and rate a list of food trucks, then view the average rating and the highest-rated truck.


#### Technologies Used
	- JAVA
	- Eclipse
	- Git/GitHub
	- Sublime Text Editor
	- Zsh

#### Lessons Learned
    - Attention to detail, read and re-read requirements.
	- Commit early, commit often, and push!
	- Format code, keep it separated (Indented)
	
	
#### How to run this program : This is a .java source code, command line project.  

You could open the project in an IDE and execute the main method using the IDE tools.

You can compile the project (.java) file on the command line, and then execute the compiled code.

The compilation and execution in the command line is subject to the proper working directory and installed JAVA Compiler and specific platform.



## Project requirements

## Food Trucks

### Overview

Users will input and rate a list of food trucks, then view the average rating and the highest-rated truck.

#### Structure

You will define a `FoodTruck` class with fields for a unique numeric id, a name ("TacoRific", "Mediterranean Medic", etc.), food type ("Tacos", "Falafel", etc.), and a numeric rating.

You will create a separate class with a `main` method that starts the program.  It will have an array to store up to five `FoodTruck` objects.  The `main` method of this class is the only `static` method in the entire project.

### User Stories

#### User Story #1

The user is prompted to input the name, food type, and rating for up to five food trucks.  For each set of input, a `FoodTruck` object is created, its fields set to the user's input, and it is added to the array.  The truck id is not input by the user, but instead assigned automatically in the `FoodTruck` constructor from a static field that is incremented as each truck is created.

#### User Story #2

If the user inputs `quit` for the food truck name, input ends immediately and the program continues.

#### User Story #3

After input is complete, the user sees a second menu from which they can choose to:

* List all existing food trucks.
* See the average rating of food trucks.
* Display the highest-rated food truck.
* Quit the program.

#### User Story #4

After a selected menu item finishes its action, the menu redisplays, allowing the user to select again, until the user selects the option to quit.

### Grading

This is a graded project. You are to have your project completed and pushed to Git by 0830 on Monday morning.

* Your working solution must be pushed to a Github repo named **FoodTruckProject** by start of class Monday morning. 
* Your Github repo has a _README.md_ with an overview of the program, topics/technologies used, and lessons you learned while working on it.
* There are no static methods other than method `main`.
* When a `FoodTruck` is created, its constructor assigns its `id` field the current value of a static field (such as (`nextTruckId`), and then increments that static field in preparation of assigning the next truck's id.
	* Having `main` or any method outside `FoodTruck.java` determining the `id` of the FoodTruck is a failed requirement.
* The user can input truck data for up to 5 food trucks.
	* The user can choose to enter less then the max of 5 trucks, by typing the word `quit` when prompted for the next new truck's name, stopping all new truck data input. The program then continues to the next menu of options.

When the user has completed input of all the trucks (5 trucks are input, or user has typed `quit` for a truck's name), the program will display the second menu to allow the user the options to display all trucks data, get the average rating, find highest rated truck, or quit the program:

* When the menu item to list all trucks is selected, each trucks properties are displayed (id, name, food type, and rating).  If less than five trucks were input, only those trucks that were input are displayed.
	* Displaying `null` for a truck is a failed requirement. 
	* Displaying only the truck name is a failed requirement.
* When the menu item to list the average rating is selected, the average rating, based on the number of input trucks entered, is displayed. Note: if the user entered only 3 of the max 5 trucks, then the average rating must be based on 3 trucks. 
	* An incorrect average is a failed requirement.
* When the menu item to show the highest rated truck is selected, the truck having the highest rating is displayed with all its properties (id, name, food type, and rating).
	* Displaying only the truck name is a failed requirement.
* Food trucks are displayed by using its `toString`, which includes all `FoodTruck` fields.
* When the menu item to quit the program is selected, the program ends with a message.
	* The program ending before the user selecting the option to `quit` is a failed requirement.

If the code:
*  meets all stated requirements by the due date, you will receive 1 point.
*  meets most of the stated requirements by the due date, you may receive .5 point.
*  does not meet the stated requirements by the due date, you may receive 0 points.

If the project receives 0 points, resubmission for potential partial credit may, at the discretion of the instructor, be granted. Ignored assignments are given 0 points with no possibility for resubmission.



<hr>

[About The Developer](https://github.com/pasciaks/)
