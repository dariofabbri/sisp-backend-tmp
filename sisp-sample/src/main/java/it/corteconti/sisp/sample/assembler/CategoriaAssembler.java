package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.model.Categoria;

public class CategoriaAssembler {
	
	/**
	 * <p>Passato per parametro un oggetto di tipo Categoria, assembla un oggetto di tipo CategoriaDto<p>
	 * @param categoria
	 * @return categoriaDto
	 */
	
	public static CategoriaDto assembleDto(Categoria categoria) {
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setIdCategoria(categoria.getCodiceCategoria());
		categoriaDto.setDescrizioneCategoria(categoria.getDescrizioneCategoria());
		
		return categoriaDto;
	}


}
