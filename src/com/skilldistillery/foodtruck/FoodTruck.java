package com.skilldistillery.foodtruck;

public class FoodTruck {

	// no static methods or fields beyond nextId

	private static int nextTruckID = 1;

	private int truckID;
	private String name;
	private String foodType;
	private int rating;

	private FoodTruck() {
		super();
		truckID = nextTruckID++;
	}

	public FoodTruck(String name, String foodType, int rating) {
		this();
		if (name == null) {
			// System.err.println("Name must not be null.");
			throw new IllegalArgumentException("Name must not be null.");

		}
		this.name = name;
		if (foodType == null) {
			// System.err.println("Food type must not be null.");
			throw new IllegalArgumentException("Food type must not be null.");

		}
		this.foodType = foodType;
		if (rating < 1 || rating > 5) {
			// System.err.println("Rating must be between 1 and 5.");
			throw new IllegalArgumentException("Rating must be between 1 and 5.");
		}
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return name + ", " + foodType + ", " + " ( " + rating + " )";
	}

}
