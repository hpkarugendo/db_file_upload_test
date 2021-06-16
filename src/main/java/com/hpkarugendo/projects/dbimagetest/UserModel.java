package com.hpkarugendo.projects.dbimagetest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserModel {
	@Id
	@GeneratedValue
	private int id;
	private String firstName, lastName, email;
	private double hotelExp, foodBeverageExp, travelExp;
	private int hotelRecId, foodBeverageRecId, travelRecId;
	public UserModel() {
		super();
	}
	public UserModel(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getHotelExp() {
		return hotelExp;
	}
	public void setHotelExp(double hotelExp) {
		this.hotelExp = hotelExp;
	}
	public double getFoodBeverageExp() {
		return foodBeverageExp;
	}
	public void setFoodBeverageExp(double foodBeverageExp) {
		this.foodBeverageExp = foodBeverageExp;
	}
	public double getTravelExp() {
		return travelExp;
	}
	public void setTravelExp(double travelExp) {
		this.travelExp = travelExp;
	}
	public int getHotelRecId() {
		return hotelRecId;
	}
	public void setHotelRecId(int hotelRecId) {
		this.hotelRecId = hotelRecId;
	}
	public int getFoodBeverageRecId() {
		return foodBeverageRecId;
	}
	public void setFoodBeverageRecId(int foodBeverageRecId) {
		this.foodBeverageRecId = foodBeverageRecId;
	}
	public int getTravelRecId() {
		return travelRecId;
	}
	public void setTravelRecId(int travelRecId) {
		this.travelRecId = travelRecId;
	}

}
