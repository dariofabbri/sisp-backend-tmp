package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;
import it.corteconti.sisp.sample.model.Sezione;

public interface SezioneRepository extends CrudRepository<Sezione, Long> {
	
}