package br.com.bank.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.bank.bank.model.Client;
import br.com.bank.bank.repository.ClientRepository;

@Service
public class ClientService {
	private ClientRepository clientRepository;

	ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client create(Client pacient) {
		return clientRepository.save(pacient);

	}

	public List findAll() {
		return clientRepository.findAll();
	}

	public Optional<Client> findById(long id) {
		return clientRepository.findById(id);
	}

	public Client update(long id, Client pacient) {
		Optional<Client> currentClient = clientRepository.findById(id);
//		if (currentClient.isPresent()) {
//			currentClient.get().setName(pacient.getName());
//			currentClient.get().setCell(pacient.getCell());
//			currentClient.get().setGender(pacient.getGender());
//			currentClient.get().setDateOfBirth(pacient.getDateOfBirth());
		return clientRepository.save(currentClient.get());
//		} else {
//			throw new ResourceNotFoundException("Client", "Client",
//					"O paciente com id: " + id + " não foi encontrado");
//		}
	}

	public void delete(long id) {
		try {
			clientRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

		}
	}
}
