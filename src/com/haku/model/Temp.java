package com.haku.model;

public class Temp {

	private String name;
	private int number;
	private String name_x;

	public Temp() {
	}

	public Temp(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public Temp(String name, int number, String name_x) {
		this.name = name;
		this.number = number;
		this.name_x = name_x;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName_x() {
		return name_x;
	}

	public void setName_x(String name_x) {
		this.name_x = name_x;
	}
	
}
