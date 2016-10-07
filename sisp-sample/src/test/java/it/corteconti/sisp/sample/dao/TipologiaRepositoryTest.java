package it.corteconti.sisp.sample.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import it.corteconti.sisp.sample.dao.TipologiaRepository;
import it.corteconti.sisp.sample.model.Tipologia;
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * Unit Test REPOSITORY TIPOLOGIA
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TipologiaRepositoryTest {

	@Autowired
	private TipologiaRepository repository;

	private String aooSezione;
	private String idAmbito;
	private String idCategoria;
	private String idTipo;
	private String idTipologia;
	
    @Before
    public void setUp() throws Exception {
        this.aooSezione = "3";
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
    public void getTipologieRepositoryTest() throws Exception {
        List tipologie = repository.getTipologie(aooSezione, idAmbito, idCategoria, idTipo);
        assertTrue(!ValidationUtil.isNull(tipologie) && tipologie.size()>0);
    }
    
    /**
     * Test metodo <em>getTipologia</em>
     * @throws <em>java.lang.Exception</em>
     */
    @Test
    public void getTipologiaRepositoryTest() throws Exception {
        Tipologia tipologia = repository.getTipologia(aooSezione, idAmbito, idCategoria, idTipo,idTipologia);
        assertTrue(tipologia != null && tipologia.getCodiceTipologia().equalsIgnoreCase(idTipologia));
    }
	
}
