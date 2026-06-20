package com.example.libraryDemo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class book {
	@Id
	private int id;
	private String title;
	private String author;
	private String category;
	private double price;
	private int noc;
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setNumberofcopies(int noc) {
		this.noc = noc;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	public int getNumberofcopies() {
		return noc;
	}
	
}
