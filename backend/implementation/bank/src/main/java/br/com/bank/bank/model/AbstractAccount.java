package br.com.bank.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.springframework.data.domain.Example;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.bank.bank.repository.AbstractAccountRepository;
@Entity
public abstract class AbstractAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonBackReference
	@JoinColumn(name = "client_id", nullable = false)
	private long clientId;

	private String number;
	private double balance;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

//	public boolean debit(double value) {
//		if (value <= 0) {
//			return false;
//		} else {
//			this.balance -= value;
//			return true;
//		}
//	}
//
//	public boolean credit(double value) {
//		if (value <= 0) {
//			return false;
//		} else {
//			this.balance += value;
//			return true;
//		}
//	}
//
//	public boolean transfer(double value, AbstractAccount account) {
//	
//	}
}
