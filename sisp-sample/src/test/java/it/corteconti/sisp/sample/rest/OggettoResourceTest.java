package it.corteconti.sisp.sample.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import it.corteconti.sisp.sample.dto.OggettoDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OggettoResourceTest {

	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;
    
    @Test
	public void getOggettoTest() throws Exception {
    	this.base = new URL("http://localhost:"+port+"/giudizio-api/sezioni/12/oggetti/61");
		ResponseEntity<OggettoDto> response = template.getForEntity(base.toString(),OggettoDto.class);
		OggettoDto oggetto = response.getBody();
		assertNotNull(oggetto);
		assertTrue(oggetto.getDescrizioneOggetto().equals("AGGANCIO DELLA PENSIONE ALLA RETRIBUZIONE"));
		
	}
	
    @Test
	public void getOggettiTest()throws Exception {
		
    	this.base = new URL("http://localhost:"+port+"/giudizio-api/sezioni/12/oggetti");
		
    	@SuppressWarnings("rawtypes")
		ResponseEntity<ArrayList> response = template.getForEntity(base.toString(),ArrayList.class);
		
		@SuppressWarnings("unchecked")
		ArrayList<OggettoDto> lista = response.getBody();
		
		assertNotNull(lista);
		assertTrue(lista.size()==170);
	}
	
}
