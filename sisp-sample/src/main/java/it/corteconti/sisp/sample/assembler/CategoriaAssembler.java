package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.model.Categoria;

public class CategoriaAssembler {

	public static CategoriaDto assembleDto(Categoria categoria) {
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setIdCategoria(categoria.getCodiceCategoria());
		categoriaDto.setDescrizioneCategoria(categoria.getDescrizioneCategoria());
		
		return categoriaDto;
	}


}
