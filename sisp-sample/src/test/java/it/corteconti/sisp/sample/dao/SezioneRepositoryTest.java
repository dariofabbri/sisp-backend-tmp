package it.corteconti.sisp.sample.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.corteconti.sisp.sample.dao.SezioneRepository;
import it.corteconti.sisp.sample.model.Sezione;

/**
 * Unit Test REPOSITORY SEZIONE
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SezioneRepositoryTest {
	
	@Autowired
	private SezioneRepository repository;

	private Long id;
	
    @Before
    public void setUp() throws Exception {
        this.id = (long) 1 ;
    }

    /**
     * Test metodo <em>get</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getSezioneRepositoryTest() throws Exception {
        Sezione s = repository.findOne(id);
        assertTrue(s != null && s.getId().longValue() == id.longValue());
    }
	
}
