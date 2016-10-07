package it.corteconti.sisp.sample.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import it.corteconti.sisp.sample.dto.ThingDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ThingResourceTest {
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;
    
    @Test
    public void getTest() throws Exception {
    	
    	this.base = new URL("http://localhost:"+port+"/api/v1/things/1");
    	
        ResponseEntity<ThingDto> response = template.getForEntity(base.toString(),ThingDto.class);
        ThingDto thingdto = response.getBody();
        assertTrue(thingdto.getDescription().equals("Pippo"));
    }
    
	@Test
    public void saveUpdateDeleteTest()throws Exception {
    	
    	this.base = new URL("http://localhost:"+port+"/api/v1/things/thing");
    	
    	/*
    	 * verifico la creazione dell'oggetto thing
    	 */
    	ThingDto thingDto = new ThingDto();
    	thingDto.setDescription("Prova Test");
    	thingDto.setLastUpdate(new Date());
    	ThingDto thingDtoOut1 = template.postForObject(base.toString(), thingDto, ThingDto.class);
    	assertNotNull( thingDtoOut1.getId() );
    	
    	/*
    	 * verifico update dell'oggetto thing
    	 */
    	this.base = new URL("http://localhost:"+port+"/api/v1/things/thing/update");
    	thingDtoOut1.setDescription("prova_test_modificata");
    	template.put(base.toString(), thingDtoOut1);
    	assertTrue(thingDtoOut1.getDescription().equals("prova_test_modificata"));
    	
    	/*
    	 * verifico la cancellazione dell'oggetto thing
    	 */
    	this.base = new URL("http://localhost:"+port+"/api/v1/things/thing/delete/"+thingDtoOut1.getId());
    	template.delete(base.toString());
    	
    }

}
