package it.corteconti.sisp.sample.rest;

import static org.junit.Assert.assertNotNull;
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

import it.corteconti.sisp.sample.dto.TipoDto;

/**
 * Unit Test REST TIPO
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TipoResourceTest {
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;
    
    // -- Costanti
    private final String PATH_REST_GET_TIPI = "/sezioni/1/ambiti/1/categorie/4/tipi";
    private final String PATH_REST_GET_TIPO = "/sezioni/1/ambiti/1/categorie/4/tipi/10";
    

    
    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/giudizio-api");
    }
    
    
    /**
     * Test metodo <em>getTipi</em>
     * @throws <em>java.lang.Exception</em>
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void getTipiTest() throws Exception {
    	String url = base.toString();
    	url += this.PATH_REST_GET_TIPI;
    	
        ResponseEntity<List> response = template.getForEntity(url, List.class);
        List<TipoDto> dtoList = response.getBody();
        
        // -- Assert
        assertNotNull(dtoList);
		assertTrue(dtoList.size() == 7);
    }
    
    
    /**
     * Test metodo <em>getTipo</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getTipoTest() throws Exception {
    	String url = base.toString();
    	url += this.PATH_REST_GET_TIPO;
    	
        ResponseEntity<TipoDto> response = template.getForEntity(url, TipoDto.class);
        TipoDto tipoDto = response.getBody();
        
        // -- Assert
        assertTrue(tipoDto.getDescrizioneTipo().equals("SOSPENSIVA"));
    }
    

}
