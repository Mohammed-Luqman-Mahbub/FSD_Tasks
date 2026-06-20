package com.example.studentDemo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class student {
	@Id
	private int id;
	private String name;
	private int age;
	private String course;
	private String email;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public String getCourse() {
		return course;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
}
