package br.com.bank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.bank.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
