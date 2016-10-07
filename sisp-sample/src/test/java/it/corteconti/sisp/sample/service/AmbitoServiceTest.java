package it.corteconti.sisp.sample.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import it.corteconti.sisp.sample.dto.AmbitoDto;
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * Unit Test SERVICE AMBITO
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AmbitoServiceTest {

	@Autowired
	private AmbitoService service;

	private String idAmbito;
	
    @Before
    public void setUp() throws Exception {
        this.idAmbito = "1";
    }

    @SuppressWarnings("rawtypes")
	@Test
    public void getAmbitiServiceTest() throws Exception {
        List ambiti = service.getAmbiti();
        assertTrue(!ValidationUtil.isNull(ambiti));
    }
    
    @Test
    public void getAmbitoServiceTest() throws Exception {
    	AmbitoDto ambito = service.getAmbito(idAmbito);
        assertTrue(ambito != null && ambito.getDescrizioneAmbito().equalsIgnoreCase("PENSIONISTICA"));
    }
	
}
