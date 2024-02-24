package com.skilldistillery.foodtruck;

public class FoodTruck {

	// no static methods or fields beyond nextId

	private static int nextTruckID = 1;

	private int truckID;
	private String name;
	private String foodType;
	private int rating;

	private int minNameLength = 1;
	private int minFoodTypeLength = 1;

	private FoodTruck() {
		truckID = nextTruckID++;
	}

	// FoodTruck must be created with a name, food type, and rating
	public FoodTruck(String name, String foodType, int rating) {
		this();
		this.setName(name);
		this.setFoodType(foodType);
		this.setRating(rating);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() < minNameLength) {
			throw new IllegalArgumentException("Name must not be null or too short!");
		}
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		if (foodType == null || foodType.length() < minFoodTypeLength) {
			throw new IllegalArgumentException("Food type must not be null or too short!");
		}
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		// NOTE: Rating ranges are hard-coded - consider making them dynamic
		if (rating < 1 || rating > 5) {
			throw new IllegalArgumentException("Rating must be between 1 and 5!");
		}
		this.rating = rating;
	}

	protected int getTruckID() {
		return truckID;
	}

	public String getRatingStars() {
		String stars = "";
		for (int i = 0; i < rating; i++) {
			stars += '\u2605'; // UNICODE star character
		}
		return stars;
	}

	@Override
	public String toString() {
		return name + ", " + foodType + ", " + " Rating: " + rating + " ( " + getRatingStars() + " )";
	}

	public String generateBootstrapCard() {
		StringBuilder sb = new StringBuilder();

		// Bootstrap card structure
		sb.append("<div class=\"card\">");
		sb.append("<div class=\"card-body\">");

		// Name and food type
		sb.append("<h5 class=\"card-title\">").append(name).append("</h5>");
		sb.append("<p class=\"card-text\">").append("Food Type: ").append(foodType).append("</p>");

		// Rating stars
		sb.append("<p class=\"card-text\">Rating: ");
		for (int i = 0; i < rating; i++) {
			sb.append("&#9733;"); // UNICODE star character
		}
		sb.append("</p>");

		sb.append("</div>");
		sb.append("</div>");

		return sb.toString();
	}

}
