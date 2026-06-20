package com.example.employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
@Entity
public class emp {
	@Id
	private int id;
	private String name;
	private String department;
	private LocalDate joiningDate; //= LocalDate.of(2026, 12, 25);
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public LocalDate getjoiningDate() {
		return joiningDate;
	}
}
