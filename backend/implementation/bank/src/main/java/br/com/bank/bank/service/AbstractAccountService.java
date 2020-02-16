package br.com.bank.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.bank.bank.model.AbstractAccount;
import br.com.bank.bank.repository.AbstractAccountRepository;

@Service
public class AbstractAccountService {
	private AbstractAccountRepository abstractAccountRepository;

	AbstractAccountService(AbstractAccountRepository abstractAccountRepository) {
		this.abstractAccountRepository = abstractAccountRepository;
	}

	public AbstractAccount create(AbstractAccount abstractAccount) {
		return abstractAccountRepository.save(abstractAccount);
	}

	public List findAll() {
		return abstractAccountRepository.findAll();
	}

	public Optional<AbstractAccount> findById(long id) {
		return abstractAccountRepository.findById(id);
	}

	public AbstractAccount update(long id, AbstractAccount abstractAccount) {
		Optional<AbstractAccount> currentAbstractAccount = abstractAccountRepository.findById(id);
		// if (currentAbstractAccount.isPresent()) {
//			currentAbstractAccount.get().setPacientId(abstractAccount.getPacientId());
//			currentAbstractAccount.get().setTime(abstractAccount.getTime());
//			currentAbstractAccount.get().setValue(abstractAccount.getValue());
		return abstractAccountRepository.save(currentAbstractAccount.get());
		// } else {
//			throw new ResourceNotFoundException("AbstractAccount", "Client",
//					"A consulta com id: " + id + "não foi encontrada");
		// }
	}

	public void delete(long id) {
		try {
			abstractAccountRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

		}
	}
}
