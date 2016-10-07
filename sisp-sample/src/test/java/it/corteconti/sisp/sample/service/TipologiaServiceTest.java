package it.corteconti.sisp.sample.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import it.corteconti.sisp.sample.dto.TipologiaDto;
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * Unit Test SERVICE TIPOLOGIA
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TipologiaServiceTest {

	@Autowired
	private TipologiaService service;

	private final Long 		aooSezione = new Long(40);
	private final String 	idAmbito = "3";
	private final String 	idCategoria = "3";
	private final String 	idTipo = "90";
	private final String 	idTipologia = "91";
	
    /**
     * Test metodo <em>getTipologie</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    @SuppressWarnings("rawtypes")
    public void getTipologieServiceTest() throws Exception {
        List tipologie = service.getTipologie(aooSezione, idAmbito, idCategoria, idTipo);
        assertTrue(!ValidationUtil.isNull(tipologie));
        assertTrue(tipologie.size()>0);
    }

    /**
     * Test metodo <em>getTipologia</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getTipologiaServiceTest() throws Exception {
        TipologiaDto tipologia = service.getTipologia(aooSezione, idAmbito, idCategoria, idTipo,idTipologia);
        assertNotNull(tipologia);
        assertTrue(tipologia.getIdTipologia().equalsIgnoreCase(idTipologia));
    }
	
}
