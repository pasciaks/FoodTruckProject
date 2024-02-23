package com.skilldistillery.foodtruck;

public class FoodTruck {

	// no static methods or fields beyond nextId

	private static int nextTruckID = 1;

	private int truckID;

	public FoodTruck() {
		super();
		truckID = nextTruckID++;
	}

	// Do not include truckID in the toString() method

	@Override
	public String toString() {
		return "FoodTruck []";
	}

}
