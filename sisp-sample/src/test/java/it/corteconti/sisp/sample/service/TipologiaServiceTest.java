package it.corteconti.sisp.sample.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
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

	private Long aooSezione;
	private String idAmbito;
	private String idCategoria;
	private String idTipo;
	private String idTipologia;
	
    @Before
    public void setUp() throws Exception {
        this.aooSezione = (long) 40;
        this.idAmbito = "3";
        this.idCategoria = "3";
        this.idTipo = "90";
        this.idTipologia = "91";
    }

    /**
     * Test metodo <em>getTipologie</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    @SuppressWarnings("rawtypes")
    public void getTipologieServiceTest() throws Exception {
        List tipologie = service.getTipologie(aooSezione, idAmbito, idCategoria, idTipo);
        assertTrue(!ValidationUtil.isNull(tipologie) && tipologie.size()>0);
    }

    /**
     * Test metodo <em>getTipologia</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getTipologiaServiceTest() throws Exception {
        TipologiaDto tipologia = service.getTipologia(aooSezione, idAmbito, idCategoria, idTipo,idTipologia);
        assertTrue(tipologia != null && tipologia.getIdTipologia().equalsIgnoreCase(idTipologia));
    }
	
}
