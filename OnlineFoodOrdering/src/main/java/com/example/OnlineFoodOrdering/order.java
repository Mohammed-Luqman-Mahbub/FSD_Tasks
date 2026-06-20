package com.example.OnlineFoodOrdering;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class order {
	@Id
	private int id;
	private int cid;
	private String item;
	private int quantity;
	private double total;
	private LocalDate date;
	private String status;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public int getCid() {
		return cid;
	}
	public String getItem() {
		return item;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getTotal() {
		return total;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "order [id=" + id + ", cid=" + cid + ", item=" + item + ", quantity=" + quantity + ", total=" + total
				+ ", date=" + date + ", status=" + status + "]";
	}
}
