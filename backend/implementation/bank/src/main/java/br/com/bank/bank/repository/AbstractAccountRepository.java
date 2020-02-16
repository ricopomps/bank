package br.com.bank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.bank.model.AbstractAccount;

@Repository
public interface AbstractAccountRepository extends JpaRepository<AbstractAccount, Long> {

}
