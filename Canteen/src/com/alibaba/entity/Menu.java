package com.alibaba.entity;

import java.time.LocalDate;

public class Menu {

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", constitute=" + constitute + ", calories="
				+ calories + ", nutritionContent=" + nutritionContent + ", nutritionVal=" + nutritionVal + ", date="
				+ date + ", meal=" + meal + ", praiseCount=" + praiseCount + ", trample=" + trample + "]";
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int id, String name, double price, String constitute, double calories, String nutritionContent,
			String nutritionVal, LocalDate date, int meal, int praiseCount, int trample) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.constitute = constitute;
		this.calories = calories;
		this.nutritionContent = nutritionContent;
		this.nutritionVal = nutritionVal;
		this.date = date;
		this.meal = meal;
		this.praiseCount = praiseCount;
		this.trample = trample;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calories);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((constitute == null) ? 0 : constitute.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + meal;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nutritionContent == null) ? 0 : nutritionContent.hashCode());
		result = prime * result + ((nutritionVal == null) ? 0 : nutritionVal.hashCode());
		result = prime * result + praiseCount;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + trample;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (Double.doubleToLongBits(calories) != Double.doubleToLongBits(other.calories))
			return false;
		if (constitute == null) {
			if (other.constitute != null)
				return false;
		} else if (!constitute.equals(other.constitute))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (meal != other.meal)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nutritionContent == null) {
			if (other.nutritionContent != null)
				return false;
		} else if (!nutritionContent.equals(other.nutritionContent))
			return false;
		if (nutritionVal == null) {
			if (other.nutritionVal != null)
				return false;
		} else if (!nutritionVal.equals(other.nutritionVal))
			return false;
		if (praiseCount != other.praiseCount)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (trample != other.trample)
			return false;
		return true;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getConstitute() {
		return constitute;
	}

	public void setConstitute(String constitute) {
		this.constitute = constitute;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public String getNutritionContent() {
		return nutritionContent;
	}

	public void setNutritionContent(String nutritionContent) {
		this.nutritionContent = nutritionContent;
	}

	public String getNutritionVal() {
		return nutritionVal;
	}

	public void setNutritionVal(String nutritionVal) {
		this.nutritionVal = nutritionVal;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getMeal() {
		return meal;
	}

	public void setMeal(int meal) {
		this.meal = meal;
	}

	public int getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}

	public int getTrample() {
		return trample;
	}

	public void setTrample(int trample) {
		this.trample = trample;
	}

	private int id;
	private String name;
	private double price;
	private String constitute;
	private double calories;
	private String nutritionContent;
	private String nutritionVal;
	private LocalDate date;
	private int meal;
	private int praiseCount;
	private int trample;
}
