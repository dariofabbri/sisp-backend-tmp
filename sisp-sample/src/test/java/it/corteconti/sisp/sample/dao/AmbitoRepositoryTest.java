package it.corteconti.sisp.sample.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import it.corteconti.sisp.sample.dao.AmbitoRepository;
import it.corteconti.sisp.sample.model.Ambito;
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * Unit Test REPOSITORY AMBITO
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class } )
public class AmbitoRepositoryTest {

	@Autowired
	private AmbitoRepository repository;

	private String idAmbito;
	
    @Before
    public void setUp() throws Exception {
        this.idAmbito = "1";
    }

    @Test
    public void getAmbitiRepositoryTest() throws Exception {
        Iterable<Ambito> ambiti = repository.findAll();
        assertTrue(!ValidationUtil.isNull(ambiti));
    }
    
    @Test
    public void getAmbitoRepositoryTest() throws Exception {
    	Ambito ambito = repository.findOne(idAmbito);
        assertTrue(ambito != null && ambito.getDescrizioneAmbito().equalsIgnoreCase("PENSIONISTICA"));
    }
	
}
