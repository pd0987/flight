package com.example.demo.ModL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name="Flight_ticket")
public class Flight {
	@Id
	private int id;
	private String passengername;
	private int date;
	private String arrival;
	private String depature;
	private int flightno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassengername() {
		return passengername; 
	}
	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public int getFlightno() {
		return flightno;
	}
	public void setFlightno(int flightno) {
		this.flightno = flightno;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", passengername=" + passengername + ", date=" + date + ", arrival=" + arrival
				+ ", depature=" + depature + ", flightno=" + flightno + "]";
	}
}

