package com.exampleAbstraction;

abstract class Item {
	private int id;
	private String title;
	private int year;

	public Item(int id, String title, int year) {
		this.id = id;
		this.title = title;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}
    abstract String getType();

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", year=" + year + "]";
	}
}
