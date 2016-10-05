package it.corteconti.sisp.sample.assembler;

import java.util.ArrayList;
import java.util.List;

import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.dto.OggettoDto;
import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.dto.TipoDto;
import it.corteconti.sisp.sample.dto.TipologiaDto;
import it.corteconti.sisp.sample.model.Categoria;
import it.corteconti.sisp.sample.model.Giudizio;
import it.corteconti.sisp.sample.model.Oggetto;
import it.corteconti.sisp.sample.model.Tipo;
import it.corteconti.sisp.sample.model.Tipologia;
import it.corteconti.sisp.util.ValidationUtil;

/**
 * Assembler Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
 * @version 1.0
 */
public class GiudizioAssembler {

	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 * @param tipo	Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
	 * @return 		<em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	public static GiudizioDto assembleDto(Giudizio giudizio) {
		
		GiudizioDto dto = new GiudizioDto();
		
		if ( giudizio.getId() != null && giudizio.getId().longValue() != 0 ) {
			dto.setIdGiudizio(giudizio.getId());
		}
		if ( giudizio.getNumero() != null && giudizio.getNumero().longValue() != 0 ) {
			dto.setNumeroGiudizio(giudizio.getNumero());
		}
		if ( giudizio.getDataApertura() != null ) {
			dto.setDataApertura(giudizio.getDataApertura());
		}
		if ( !ValidationUtil.isBlankOrNull(giudizio.getDescrizione()) ) {
			dto.setDescrizione(giudizio.getDescrizione());
		}
		if ( !ValidationUtil.isBlankOrNull(giudizio.getNote()) ) {
			dto.setNote(giudizio.getNote());
		}
		if ( !ValidationUtil.isBlankOrNull(giudizio.getTestoQuesito()) ) {
			dto.setTestoQuesito(giudizio.getTestoQuesito());
		}
		if ( !ValidationUtil.isBlankOrNull(giudizio.getRiferimentoAtto()) ) {
			dto.setRiferimentoAtto(giudizio.getRiferimentoAtto());
		}
		if ( giudizio.getIdSezione() != null && giudizio.getIdSezione().longValue() != 0 ) {
			SezioneDto sezioneDto = new SezioneDto();
			sezioneDto.setIdSezione(giudizio.getIdSezione());
			dto.setSezione(sezioneDto);
		}
		// -- Categoria
		if ( giudizio.getCategoria() != null && !ValidationUtil.isBlankOrNullOrZero(giudizio.getCategoria().getCodiceCategoria()) ) {
			CategoriaDto categoriaDto = CategoriaAssembler.assembleDto(giudizio.getCategoria());
			dto.setCategoria(categoriaDto);
		}
		// -- Tipo
		if ( giudizio.getTipo() != null && !ValidationUtil.isBlankOrNullOrZero(giudizio.getTipo().getCodiceTipo()) ) {
			TipoDto tipoDto = TipoAssembler.assembleDto(giudizio.getTipo());
			dto.setTipo(tipoDto);
		}
		// -- Tipologia
		if ( giudizio.getTipologia() != null && !ValidationUtil.isBlankOrNullOrZero(giudizio.getTipologia().getCodiceTipologia()) ) {
			TipologiaDto tipologiaDto = TipologiaAssembler.assembleDto(giudizio.getTipologia());
			dto.setTipologia(tipologiaDto);
		}
		// -- Lista Oggetti
		if ( giudizio.getListaOggetti() != null && giudizio.getListaOggetti().size() > 0 ) {
			List<OggettoDto> oggettoDtoList = new ArrayList<OggettoDto>();
			
			for ( Oggetto oggetto : giudizio.getListaOggetti() ) {
				OggettoDto oggettoDto = OggettoAssembler.assembleDto(oggetto);
				oggettoDtoList.add(oggettoDto);
			}
			
			dto.setOggetti(oggettoDtoList);
		}
		
		return dto;
	}
	
	
	/**
	 * Ritorna un'entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
	 * @param dto	dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 * @return		<em>it.corteconti.sisp.sample.model.Giudizio</em>
	 */
	public static Giudizio disassembleDto(GiudizioDto dto) {
		
		Giudizio giudizio = new Giudizio();
		
		if ( dto.getIdGiudizio() != null && dto.getIdGiudizio().longValue() != 0 ) {
			giudizio.setId(dto.getIdGiudizio());
		}
		if ( dto.getNumeroGiudizio() != null && dto.getNumeroGiudizio().longValue() != 0 ) {
			giudizio.setNumero(dto.getNumeroGiudizio());
		}
		if ( dto.getDataApertura() != null ) {
			giudizio.setDataApertura(dto.getDataApertura());
		}
		if ( !ValidationUtil.isBlankOrNull(dto.getDescrizione()) ) {
			giudizio.setDescrizione(dto.getDescrizione());
		}
		if ( !ValidationUtil.isBlankOrNull(dto.getNote()) ) {
			giudizio.setNote(dto.getNote());
		}
		if ( !ValidationUtil.isBlankOrNull(dto.getTestoQuesito()) ) {
			giudizio.setTestoQuesito(dto.getTestoQuesito());
		}
		if ( !ValidationUtil.isBlankOrNull(dto.getRiferimentoAtto()) ) {
			giudizio.setRiferimentoAtto(dto.getRiferimentoAtto());
		}
		if ( dto.getSezione().getIdSezione() != null && dto.getSezione().getIdSezione().longValue() != 0 ) {
			giudizio.setIdSezione(dto.getSezione().getIdSezione());
		}
		// -- Categoria
		if ( dto.getCategoria() != null && !ValidationUtil.isBlankOrNullOrZero(dto.getCategoria().getIdCategoria()) ) {
			Categoria categoria = CategoriaAssembler.disassembleDto(dto.getCategoria());
			giudizio.setCategoria(categoria);
		}
		// -- Tipo
		if ( dto.getTipo() != null && !ValidationUtil.isBlankOrNullOrZero(dto.getTipo().getIdTipo()) ) {
			Tipo tipo = TipoAssembler.disassembleDto(dto.getTipo());
			giudizio.setTipo(tipo);
		}
		// -- Tipologia
		if ( dto.getTipologia() != null && !ValidationUtil.isBlankOrNullOrZero(dto.getTipologia().getIdTipologia()) ) {
			Tipologia tipologia = TipologiaAssembler.disassembleDto(dto.getTipologia());
			giudizio.setTipologia(tipologia);
		}
		// -- Lista Oggetti
		if ( dto.getOggetti() != null && dto.getOggetti().size() > 0 ) {
			List<Oggetto> oggettoList = new ArrayList<Oggetto>();
			
			for ( OggettoDto oggettoDto : dto.getOggetti() ) {
				Oggetto oggetto = OggettoAssembler.disassembleDto(oggettoDto);
				oggettoList.add(oggetto);
			}
			
			giudizio.setListaOggetti(oggettoList);
		}
		
		return giudizio;
	}
	
	
}
