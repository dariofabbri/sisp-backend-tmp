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
		
		if ( giudizio.getId() != null && giudizio.getId().longValue() != 0 )
			dto.setIdGiudizio(giudizio.getId());
		if ( giudizio.getNumero() != null && giudizio.getNumero().longValue() != 0 )
			dto.setNumeroGiudizio(giudizio.getNumero());
		if ( giudizio.getDataApertura() != null )
			dto.setDataApertura(giudizio.getDataApertura());
		if ( giudizio.getDescrizione() != null && !giudizio.getDescrizione().equals("") )
			dto.setDescrizione(giudizio.getDescrizione());
		if ( giudizio.getNote() != null && !giudizio.getNote().equals("") )
			dto.setNote(giudizio.getNote());
		if ( giudizio.getTestoQuesito() != null && !giudizio.getTestoQuesito().equals("") )
			dto.setTestoQuesito(giudizio.getTestoQuesito());
		if ( giudizio.getRiferimentoAtto() != null && !giudizio.getRiferimentoAtto().equals("") )
			dto.setRiferimentoAtto(giudizio.getRiferimentoAtto());
		if ( giudizio.getIdSezione() != null && giudizio.getIdSezione().longValue() != 0 ) {
			SezioneDto sezioneDto = new SezioneDto();
			sezioneDto.setIdSezione(giudizio.getIdSezione());
			dto.setSezioneDto(sezioneDto);
		}
		// -- Categoria
		if ( giudizio.getCategoria() != null ) {
			CategoriaDto categoriaDto = CategoriaAssembler.assembleDto(giudizio.getCategoria());
			dto.setCategoriaDto(categoriaDto);
		}
		// -- Tipo
		if ( giudizio.getTipo() != null ) {
			TipoDto tipoDto = TipoAssembler.assembleDto(giudizio.getTipo());
			dto.setTipoDto(tipoDto);
		}
		// -- Tipologia
		if ( giudizio.getTipologia() != null ) {
			TipologiaDto tipologiaDto = TipologiaAssembler.assembleDto(giudizio.getTipologia());
			dto.setTipologiaDto(tipologiaDto);
		}
		// -- Lista Oggetti
		if ( giudizio.getListaOggetti() != null && giudizio.getListaOggetti().size() > 0 ) {
			List<OggettoDto> oggettoDtoList = new ArrayList<OggettoDto>();
			
			for ( Oggetto oggetto : giudizio.getListaOggetti() ) {
				OggettoDto oggettoDto = OggettoAssembler.assembleDto(oggetto);
				oggettoDtoList.add(oggettoDto);
			}
			
			dto.setOggettoDtoList(oggettoDtoList);
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
		
		if ( dto.getIdGiudizio() != null && dto.getIdGiudizio().longValue() != 0 )
			giudizio.setId(dto.getIdGiudizio());
		if ( dto.getNumeroGiudizio() != null && dto.getNumeroGiudizio().longValue() != 0 )
			giudizio.setNumero(dto.getNumeroGiudizio());
		if ( dto.getDataApertura() != null )
			giudizio.setDataApertura(dto.getDataApertura());
		if ( dto.getDescrizione() != null && !dto.getDescrizione().equals("") )
			giudizio.setDescrizione(dto.getDescrizione());
		if ( dto.getNote() != null && !dto.getNote().equals("") )
			giudizio.setNote(dto.getNote());
		if ( dto.getTestoQuesito() != null && !dto.getTestoQuesito().equals("") )
			giudizio.setTestoQuesito(dto.getTestoQuesito());
		if ( dto.getRiferimentoAtto() != null && !dto.getRiferimentoAtto().equals("") )
			giudizio.setRiferimentoAtto(dto.getRiferimentoAtto());
		if ( dto.getSezione().getIdSezione() != null && dto.getSezione().getIdSezione().longValue() != 0 )
			giudizio.setIdSezione(dto.getSezione().getIdSezione());
		// -- Categoria
		if ( dto.getCategoria() != null ) {
			Categoria categoria = CategoriaAssembler.disassembleDto(dto.getCategoria());
			giudizio.setCategoria(categoria);
		}
		// -- Tipo
		if ( dto.getTipo() != null ) {
			Tipo tipo = TipoAssembler.disassembleDto(dto.getTipo());
			giudizio.setTipo(tipo);
		}
		// -- Tipologia
		if ( dto.getTipologia() != null ) {
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
