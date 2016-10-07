package it.corteconti.sisp.sample.dao;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import it.corteconti.sisp.sample.model.Giudizio;

/**
 * Unit Test REST GIUDIZIO
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GiudizioRepositoryTest {
	
	@Autowired
	private GiudizioRepository repository;
	
	@LocalServerPort
    private int port;

    // -- Costanti
    private final Long	 	ID_SEZIONE = new Long(12);
    private final Long 		NUMERO_GIUDIZIO = new Long(6);
    private final String 	ID_TIPO = "10";
    private final String 	ID_CATEGORIA = "1";
    
    /**
     * Test metodo <em>findByIdSezioneAndNumeroAndTipoCodiceTipoAndCategoriaCodiceCategoria</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getGiudizioBySezioneAndNumeroAndTipoAndCategoriaRepositoryTest() throws Exception {
    	Giudizio giudizio = repository.findByIdSezioneAndNumeroAndTipoCodiceTipoAndCategoriaCodiceCategoria(ID_SEZIONE,NUMERO_GIUDIZIO,ID_TIPO,ID_CATEGORIA); 
        // -- Assert
        assertTrue(giudizio.getDescrizione().equals("GIUDIZIO TEST"));
        assertTrue(giudizio.getNote().equals("NOTE TEST"));
    }

}
