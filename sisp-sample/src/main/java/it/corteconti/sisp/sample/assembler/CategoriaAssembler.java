package it.corteconti.sisp.sample.assembler;

import java.util.ArrayList;
import java.util.List;

import it.corteconti.sisp.sample.dto.CategoriaArrayDto;
import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.model.CategoriaTipoTipologia;

public class CategoriaAssembler {

	public static CategoriaArrayDto assembleArrayDto(List<CategoriaTipoTipologia> lista){
		
		CategoriaArrayDto result = new CategoriaArrayDto();
		List<CategoriaDto> listaCategorieDto = new ArrayList<CategoriaDto>();
		
		for(CategoriaTipoTipologia categoria : lista){
			CategoriaDto categoriaDto = assembleDto(categoria);
			listaCategorieDto.add(categoriaDto);
		}
		
		result.setArray(listaCategorieDto.toArray(new CategoriaDto[0]));
		
		return result;
		
	}

	public static CategoriaDto assembleDto(CategoriaTipoTipologia categoria) {
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setIdCategoria(categoria.getCategoria().getCodiceCategoria());
		categoriaDto.setDescrizioneCategoria(categoria.getCategoria().getDescrizioneCategoria());
		categoriaDto.setAmbito(categoria.getAmbito().getDescrizioneAmbito());
		
		return categoriaDto;
	}


}
