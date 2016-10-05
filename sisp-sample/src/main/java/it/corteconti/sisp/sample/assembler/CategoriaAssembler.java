package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.model.Categoria;

/**
 * Assembler Entità <em>it.corteconti.sisp.sample.model.Categoria</em>
 * @version 1.0
 */
public class CategoriaAssembler {
	
	private CategoriaAssembler(){
		
	}
	
	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.CategoriaDto</em>
	 * @param categoria	Entità <em>it.corteconti.sisp.sample.model.Categoria</em>
	 * @return 			<em>it.corteconti.sisp.sample.dto.CategoriaDto</em>
	 */
	public static CategoriaDto assembleDto(Categoria categoria) {
		
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setIdCategoria(categoria.getCodiceCategoria());
		categoriaDto.setDescrizioneCategoria(categoria.getDescrizioneCategoria());
		
		return categoriaDto;
	}
	
	/**
	 * Ritorna un'entità <em>it.corteconti.sisp.sample.model.Categoria</em>
	 * @param dto	dto <em>it.corteconti.sisp.sample.dto.CategoriaDto</em>
	 * @return		<em>it.corteconti.sisp.sample.model.Categoria</em>
	 */
	public static Categoria disassembleDto(CategoriaDto dto) {
		
		Categoria categoria = new Categoria();
		
		categoria.setCodiceCategoria(dto.getIdCategoria());
		categoria.setDescrizioneCategoria(dto.getDescrizioneCategoria());
		
		return categoria;
	}
	
	
}
