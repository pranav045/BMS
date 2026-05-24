package com.pranav.BMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	@Id
	private String account_no;
	private String acc_Type;
	private double balance;

	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAcc_Type() {
		return acc_Type;
	}

	public void setAcc_Type(String acc_Type) {
		this.acc_Type = acc_Type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [No=" + account_no + ", Type=" + acc_Type + ", Balance=" + balance + "]";
	}
}
