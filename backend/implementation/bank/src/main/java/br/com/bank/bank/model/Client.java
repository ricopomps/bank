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
}
