package br.com.bank.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bank.bank.exception.ResourceNotFoundException;
import br.com.bank.bank.model.Client;
import br.com.bank.bank.service.ClientService;

@RestController()
@RequestMapping("/api/v1/client")
public class ClientController {
	private ClientService clientService;

	ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	public Client create(@RequestBody Client client) {
		return clientService.create(client);
	}

	@GetMapping
	public List findAll() {
		return clientService.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		Optional<Client> client = clientService.findById(id);
		if (client.isPresent()) {
			return ResponseEntity.ok().body(client);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Client client) {
		try {
			Client updatedClient = clientService.update(id, client);
			return ResponseEntity.ok().body(updatedClient);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity delete(@PathVariable long id) {
		clientService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
