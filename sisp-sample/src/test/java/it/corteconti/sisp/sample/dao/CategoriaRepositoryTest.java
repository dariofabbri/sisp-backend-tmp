package it.corteconti.sisp.sample.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.corteconti.sisp.sample.model.Categoria;

/**
 * <p>Unit test per la classe <em>it.corteconti.sisp.sample.dao.CategoriaRepository<em><p>
 * @version 1.0
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriaRepositoryTest {

	@Autowired
	private CategoriaRepository repository;
	
	
	/**
	 * <p>Test per il metodo findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAoo<p>
	 */
	@Test
	public void findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAooTest(){
		
		String codiceAmbito="1"; 
		String codiceLivelloAoo="1";
		
		List<Categoria> categorie = repository.findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAoo(codiceAmbito, codiceLivelloAoo);
		
		assertTrue( categorie.size() == 3 );
		
	}
	
	/**
	 * <p>Test per il metodo findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAooAndIdCategoria<p>
	 */
	@Test
	public void findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAooAndIdCategoriaTest(){
		
		String codiceAmbito = "1"; 
		String codiceLivelloAoo = "1";
		String categoriaId = "5";
		
		Categoria categoria = repository.findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAooAndIdCategoria(codiceAmbito, codiceLivelloAoo, categoriaId);
		
		assertTrue( categoriaId.equals( categoria.getCodiceCategoria() ) );		
		
		
	}
	
	
	
}
