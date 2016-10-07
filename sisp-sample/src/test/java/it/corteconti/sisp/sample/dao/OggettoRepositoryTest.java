package it.corteconti.sisp.sample.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.corteconti.sisp.sample.model.Oggetto;

/**
 * <p>Unit test per la classe <em>it.corteconti.sisp.sample.dao.OggettoRepository<em><p>
 * @version 1.0
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OggettoRepositoryTest {

	
	@Autowired
	private OggettoRepository repository;
	
	/**
	 * <p>Test per il metodo findListOggettoByIdSezione<p>
	 * @throws Exception
	 */
	@Test
    public void findListOggettoByIdSezioneTest() throws Exception {
        
		List<Oggetto> oggetti = repository.findListOggettoByIdSezione(new Long(12)) ;
		
		assertNotNull(oggetti);
		assertTrue(oggetti.size() == 170);
		
    }
	
	/**
	 * <p>Test per il metodo findOggettoByIdSezioneAndIdOggetto<p>
	 * @throws Exception
	 */
	@Test
    public void findOggettoByIdSezioneAndIdOggettoTest() throws Exception {
        
		Long idOggetto = new Long(61);
		Long idSezione = new Long(12);
		
		Oggetto oggetto = repository.findOggettoByIdSezioneAndIdOggetto(idSezione, idOggetto);
		
		assertNotNull( oggetto );
		assertTrue( idOggetto.equals(oggetto.getCodiceOggetto()) );
		
    }
	
}
