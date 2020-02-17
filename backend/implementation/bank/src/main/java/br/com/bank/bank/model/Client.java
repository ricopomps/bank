package br.com.bank.bank.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cpf;
	private String name;

//	@JsonBackReference
//	@JoinColumn(name = "abstract_account_id", nullable = false)
	@ElementCollection
	private List<AbstractAccount> accounts;
	
	public Client() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AbstractAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AbstractAccount> accounts) {
		this.accounts = accounts;
	}
	
	
}
