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

import it.corteconti.sisp.sample.dto.ThingDto;
import it.corteconti.sisp.sample.dto.TipologiaDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TipologiaRestTest {
	
	@LocalServerPort
    private int port;

    private URL baseTipologia;
    private URL baseTipologie;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.baseTipologia = new URL("http://localhost:"+port+"/giudizio-api/sezioni/40/ambiti/3/categorie/3/tipi/90/tipologie/91");
        this.baseTipologie = new URL("http://localhost:"+port+"/giudizio-api/sezioni/40/ambiti/3/categorie/3/tipi/90/tipologie");
    }

    @Test
    public void getTipologia() throws Exception {
        ResponseEntity<TipologiaDto> response = template.getForEntity(baseTipologia.toString(),TipologiaDto.class);
        TipologiaDto dto = response.getBody();
        assertTrue(dto!=null);
    }
    
    @Test
    public void getTipologie() throws Exception {
        ResponseEntity<List> response = template.getForEntity(baseTipologie.toString(),List.class);
        List dto = response.getBody();
        assertTrue(dto.size()>0);
    }
	
	

}
