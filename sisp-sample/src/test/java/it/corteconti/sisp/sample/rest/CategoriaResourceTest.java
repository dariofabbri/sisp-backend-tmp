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

import it.corteconti.sisp.sample.dto.CategoriaDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriaResourceTest {
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;
    
    @Test
	public void getCategoriaTest() throws Exception {
		
    	this.base = new URL("http://localhost:"+port+"/giudizio-api/sezioni/1/ambiti/1/categorie/4");
		ResponseEntity<CategoriaDto> response = template.getForEntity(base.toString(),CategoriaDto.class);
		CategoriaDto categoria = response.getBody();
		assertNotNull(categoria);
		assertTrue(categoria.getDescrizioneCategoria().equals("PENSIONI CIVILI"));
		
	}
	
    @Test
	public void getCategorieTest()throws Exception {
		
    	this.base = new URL("http://localhost:"+port+"/giudizio-api/sezioni/1/ambiti/1/categorie");
		
    	@SuppressWarnings("rawtypes")
		ResponseEntity<ArrayList> response = template.getForEntity(base.toString(),ArrayList.class);
		
		@SuppressWarnings("unchecked")
		ArrayList<CategoriaDto> lista = response.getBody();
		
		assertNotNull(lista);
		assertTrue(lista.size()==3);
	}
	
}
