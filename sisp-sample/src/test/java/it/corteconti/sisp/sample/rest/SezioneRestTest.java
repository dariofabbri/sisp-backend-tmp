package it.corteconti.sisp.sample.rest;

import static org.junit.Assert.assertTrue;

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
import it.corteconti.sisp.util.ValidationUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SezioneRestTest {
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:"+port+"/giudizio-api/sezioni/40");
    }

    @Test
    public void getSezione() throws Exception {
        ResponseEntity<SezioneDto> response = template.getForEntity(base.toString(),SezioneDto.class);
        SezioneDto dto = response.getBody();
        assertTrue(dto!=null && !ValidationUtil.isBlankOrNull(dto.getDescrizioneSezione()));
    }
	
	

}
