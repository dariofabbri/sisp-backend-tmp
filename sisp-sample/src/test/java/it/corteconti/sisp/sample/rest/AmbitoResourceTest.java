package it.corteconti.sisp.sample.rest;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import it.corteconti.sisp.sample.dto.AmbitoDto;

/**
 * Unit Test REST AMBITO
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AmbitoResourceTest {
	
	@LocalServerPort
    private int port;

    private URL baseAmbiti;
    private URL baseAmbito;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.baseAmbiti = new URL("http://localhost:"+port+"/giudizio-api/ambiti/");
        this.baseAmbito = new URL("http://localhost:"+port+"/giudizio-api/ambiti/1");
    }

    /**
     * Test metodo <em>getAmbito</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getAmbitoTest() throws Exception {
        ResponseEntity<AmbitoDto> response = template.getForEntity(baseAmbito.toString(),AmbitoDto.class);
        AmbitoDto dto = response.getBody();
        assertTrue(dto!=null && dto.getDescrizioneAmbito().equalsIgnoreCase("PENSIONISTICA"));
    }
    
    /**
     * Test metodo <em>getAmbiti</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    @SuppressWarnings("rawtypes")
    public void getAmbitiTest() throws Exception {
        ResponseEntity<List> response = template.getForEntity(baseAmbiti.toString(),List.class);
        List dto = response.getBody();
        assertTrue(dto.size()>0);
    }
	
	

}
