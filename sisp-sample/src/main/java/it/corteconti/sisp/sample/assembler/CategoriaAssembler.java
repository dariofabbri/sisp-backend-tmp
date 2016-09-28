package it.corteconti.sisp.sample.assembler;


import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.model.CategoriaTipoTipologia;

public class CategoriaAssembler {

//	public static CategoriaArrayDto assembleArrayDto(List<CategoriaTipoTipologia> lista){
//		
//		CategoriaArrayDto result = new CategoriaArrayDto();
//		List<CategoriaDto> listaCategorieDto = new ArrayList<CategoriaDto>();
//		
//		lista.forEach(c -> {
//			CategoriaDto categoriaDto = assembleDto(c);
//			listaCategorieDto.add(categoriaDto);
//		});
//		
//		result.setArray(listaCategorieDto.toArray(new CategoriaDto[0]));
//		
//		return result;
//		
//	}

	public static CategoriaDto assembleDto(CategoriaTipoTipologia categoria) {
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setIdCategoria((categoria.getCategoria()!=null)?categoria.getCategoria().getCodiceCategoria():"");
		categoriaDto.setDescrizioneCategoria((categoria.getCategoria()!=null)?categoria.getCategoria().getDescrizioneCategoria():"");
		categoriaDto.setAmbito((categoria.getAmbito()!=null)?categoria.getAmbito().getDescrizioneAmbito():"");
		
		return categoriaDto;
	}


}
