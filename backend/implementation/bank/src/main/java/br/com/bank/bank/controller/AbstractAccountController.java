package br.com.bank.bank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bank.bank.exception.ResourceNotFoundException;
import br.com.bank.bank.model.AbstractAccount;
import br.com.bank.bank.model.Account;
import br.com.bank.bank.service.AbstractAccountService;

@RestController()
@RequestMapping("/api/v1/Account")
public class AbstractAccountController {
	private AbstractAccountService abstractAccountService;

	AbstractAccountController(AbstractAccountService abstractAccountService) {
		this.abstractAccountService = abstractAccountService;
	}

	@PostMapping
	public AbstractAccount create(@RequestBody Account account) {
		return abstractAccountService.create(account);
	}

	@GetMapping
	public List findAll() {
		return abstractAccountService.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable("id") long id, @RequestBody Account account) {
		try {
			AbstractAccount updateAbstractAccount = abstractAccountService.update(id, account);
			return ResponseEntity.ok().body(updateAbstractAccount);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity delete(@PathVariable long id) {
		abstractAccountService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
