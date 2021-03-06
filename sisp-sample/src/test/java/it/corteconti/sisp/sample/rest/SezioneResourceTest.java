package it.corteconti.sisp.sample.rest;

import static org.junit.Assert.*;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * Unit Test REST SEZIONE
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SezioneResourceTest {
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:"+port+"/giudizio-api/sezioni/40");
    }

    /**
     * Test metodo <em>get</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getSezioneTest() throws Exception {
        ResponseEntity<SezioneDto> response = template.getForEntity(base.toString(),SezioneDto.class);
        SezioneDto dto = response.getBody();
        assertNotNull(dto);
        assertTrue(!ValidationUtil.isBlankOrNull(dto.getDescrizioneSezione()));
    }
	
	

}
