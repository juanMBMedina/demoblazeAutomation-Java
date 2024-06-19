package com.pragma.models;

public class Customer {
	
	private String fullName;
	private String country;
	private String city;
	private String creditCard;
	private String month;
	private String year;
	private Integer amount;
	
	public Customer(String fullName, String country, String city, String creditcard, String month, String year) {
		super();
		this.fullName = fullName;
		this.country = country;
		this.city = city;
		this.creditCard = creditcard;
		this.month = month;
		this.year = year;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getFullName() {
		return fullName;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Customer [fullName=" + fullName + ", country=" + country + ", city=" + city + ", creditCard="
				+ creditCard + ", month=" + month + ", year=" + year + ", amount=" + amount + "]";
	}
	
}
