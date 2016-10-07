package it.corteconti.sisp.sample.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
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

import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.dto.OggettoDto;
import it.corteconti.sisp.sample.dto.TipoDto;
import it.corteconti.sisp.sample.dto.TipologiaDto;

/**
 * Unit Test REST GIUDIZIO
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GiudizioResourceTest {
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;
    
    // -- Costanti
    private final String PATH_REST_GET_GIUDIZIO = "/giudizi/5";
    private final String PATH_REST_GET_GIUDIZIO_QUERY_STRING = "/sezioni/12/giudizi?numero=6&tipoId=10&categoriaId=1";
    private final String PATH_REST_SAVE = "/sezioni/40/ambiti/3/giudizi";
    
    
    /**
     * Popolamento dto di colloquio
     * @return <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
     */
    private GiudizioDto getDto() {
    	GiudizioDto dto = new GiudizioDto();
    	
    	Calendar c = Calendar.getInstance();
		c.set(2016, 9, 2, 0, 0, 0);
		
		dto.setDataApertura(c.getTime());
		dto.setDescrizione("JUNIT TEST DESCRIZIONE POST GIUDIZIO");
		dto.setNote("JUNIT TEST NOTE POST GIUDIZIO");
		dto.setRiferimentoAtto("JUNIT TEST RIF. ATTO POST GIUDIZIO");
		dto.setTestoQuesito("JUNIT TEST TESTO QUESITO POST GIUDIZIO");
		
		CategoriaDto cDto = new CategoriaDto();
		cDto.setIdCategoria("3");
		dto.setCategoria(cDto);
		
		TipoDto tDto = new TipoDto();
		tDto.setIdTipo("5");
		dto.setTipo(tDto);
		
		TipologiaDto tpDto = new TipologiaDto();
		tpDto.setIdTipologia("91");
		dto.setTipologia(tpDto);
		
		List<OggettoDto> oggetti = new ArrayList<>();
		OggettoDto oDto1 = new OggettoDto();
		oDto1.setIdOggetto(new Long(3));
		oggetti.add(oDto1);
		OggettoDto oDto2 = new OggettoDto();
		oDto2.setIdOggetto(new Long(4));
		oggetti.add(oDto2);
		dto.setOggetti(oggetti);
    	
    	return dto;
    }

    
    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/giudizio-api");
    }
    
    
    /**
     * Test metodo <em>getGiudizio</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getGiudizioTest() throws Exception {
    	String url = base.toString();
    	url += this.PATH_REST_GET_GIUDIZIO;
    	
        ResponseEntity<GiudizioDto> response = this.template.getForEntity(url, GiudizioDto.class);
        GiudizioDto giudiziodto = response.getBody();
        
        // -- Assert
        assertTrue(giudiziodto.getDescrizione().equals("GIUDIZIO TEST"));
        assertTrue(giudiziodto.getNote().equals("NOTE TEST"));
    }
    
    
    /**
     * Test metodo <em>getGiudizioBySezioneAndNumeroAndTipoAndCategoria</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getGiudizioBySezioneAndNumeroAndTipoAndCategoriaTest() throws Exception {
    	String url = base.toString();
    	url += this.PATH_REST_GET_GIUDIZIO_QUERY_STRING;
    	
        ResponseEntity<GiudizioDto> response = this.template.getForEntity(url, GiudizioDto.class);
        GiudizioDto giudiziodto = response.getBody();
        
        // -- Assert
        assertTrue(giudiziodto.getDescrizione().equals("GIUDIZIO TEST"));
        assertTrue(giudiziodto.getNote().equals("NOTE TEST"));
    }
    
    
    /**
     * Test metodo <em>save</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void saveTest() throws Exception {
    	String url = base.toString();
    	url += this.PATH_REST_SAVE;
    	
    	GiudizioDto giudiziodto = this.getDto();
    	GiudizioDto giudizioSavedto = this.template.postForObject(url, giudiziodto, GiudizioDto.class);
    	
    	// -- Assert
    	assertNotNull( giudizioSavedto.getIdGiudizio() );
    }
	
	

}
