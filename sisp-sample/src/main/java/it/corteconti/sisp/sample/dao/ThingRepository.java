package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Thing;

public interface ThingRepository extends CrudRepository<Thing, Long> {

}
