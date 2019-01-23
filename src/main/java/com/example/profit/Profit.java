package com.example.profit;

public class Profit {

	private String name;
	private String profitAmount;
	
	public Profit() {

	}
	
	public Profit(String name, String profitAmount) {
		super();
		this.name = name;
		this.profitAmount = profitAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(String profitAmount) {
		this.profitAmount = profitAmount;
	}	
}
