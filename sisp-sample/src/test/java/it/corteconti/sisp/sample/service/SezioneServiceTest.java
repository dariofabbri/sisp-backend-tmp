package it.corteconti.sisp.sample.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import it.corteconti.sisp.sample.dto.SezioneDto;

/**
 * Unit Test SERVICE SEZIONE
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SezioneServiceTest {
	
	@Autowired
	private SezioneService service;

	private Long id;
	
    @Before
    public void setUp() throws Exception {
        this.id = (long) 1 ;
    }

    @Test
    public void getSezioneServiceTest() throws Exception {
        SezioneDto s = service.findSezioniById(id);
        assertTrue(s != null && s.getIdSezione().longValue() == id.longValue());
    }
	
}
