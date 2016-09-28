package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.corteconti.sisp.sample.assembler.CategoriaAssembler;
import it.corteconti.sisp.sample.dao.CategoriaRepository;
import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.dto.SezioniDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Categoria;

@Service
@Transactional
public class CategoriaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CategoriaService.class);
	
	@Autowired
	private SezioniService sezioniService;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public List<CategoriaDto> findCategorieBySezioneAndAmbito(Long idSezione , String idAmbito) {
		
		SezioniDto sezDto = sezioniService.findSezioniById(idSezione);
		List<Categoria> lista = categoriaRepository.findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAoo(idAmbito, ""+sezDto.getLivelloSezione());
		if (lista == null || lista.isEmpty()) {
			LOG.debug("Categorie non trovate.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Categoria with Ambito {0} and Sezione {1} not found.", idAmbito, idSezione));
		}
		
		List<CategoriaDto> listaCategorieDto = new ArrayList<CategoriaDto>();
		
		lista.forEach(c -> {
			CategoriaDto categoriaDto = CategoriaAssembler.assembleDto(c);
			listaCategorieDto.add(categoriaDto);
		});
		
		return listaCategorieDto;
	}

	public CategoriaDto findByCategorieBySezioneAndAmbitoAndCategoria(Long sezioneId, String ambitoId, String categoriaId) {
		
		SezioniDto sezioneDto = sezioniService.findSezioniById(sezioneId);

		Categoria categoria = categoriaRepository.findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAooAndIdCategoria(ambitoId, ""+sezioneDto.getIdSezione(), categoriaId);
		
		if (categoria == null ) {
			LOG.debug("Categorie non trovate.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Categoria {0} not found.", categoriaId));
		}
		
		return CategoriaAssembler.assembleDto(categoria);
		
	}
	
}