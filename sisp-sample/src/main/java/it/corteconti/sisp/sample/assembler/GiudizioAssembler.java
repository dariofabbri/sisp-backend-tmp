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
     * Costruttore privato, impedisce l'instanziazione
     */
	private GiudizioAssembler() {}
	
	

	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 * @param tipo	Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
	 * @return 		<em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	public static GiudizioDto assembleDto(Giudizio giudizio) {
		
		GiudizioDto dto = new GiudizioDto();
		
		dto.setIdGiudizio(giudizio.getId());
		dto.setNumeroGiudizio(giudizio.getNumero());
		dto.setDataApertura(giudizio.getDataApertura());
		dto.setDescrizione(giudizio.getDescrizione());
		dto.setNote(giudizio.getNote());
		dto.setTestoQuesito(giudizio.getTestoQuesito());
		dto.setRiferimentoAtto(giudizio.getRiferimentoAtto());
		
		if ( !ValidationUtil.isNullOrZero(giudizio.getIdSezione()) ) {
			SezioneDto sezioneDto = new SezioneDto();
			sezioneDto.setIdSezione(giudizio.getIdSezione());
			dto.setSezione(sezioneDto);
		}
		// -- Categoria
		if ( !ValidationUtil.isNull(giudizio.getCategoria()) && !ValidationUtil.isBlankOrNullOrZero(giudizio.getCategoria().getCodiceCategoria()) ) {
			CategoriaDto categoriaDto = CategoriaAssembler.assembleDto(giudizio.getCategoria());
			dto.setCategoria(categoriaDto);
		}
		// -- Tipo
		if ( !ValidationUtil.isNull(giudizio.getTipo()) && !ValidationUtil.isBlankOrNullOrZero(giudizio.getTipo().getCodiceTipo()) ) {
			TipoDto tipoDto = TipoAssembler.assembleDto(giudizio.getTipo());
			dto.setTipo(tipoDto);
		}
		// -- Tipologia
		if ( !ValidationUtil.isNull(giudizio.getTipologia()) && !ValidationUtil.isBlankOrNullOrZero(giudizio.getTipologia().getCodiceTipologia()) ) {
			TipologiaDto tipologiaDto = TipologiaAssembler.assembleDto(giudizio.getTipologia());
			dto.setTipologia(tipologiaDto);
		}
		// -- Lista Oggetti
		if ( !ValidationUtil.isNullOrEmpty(giudizio.getListaOggetti()) ) {
			List<OggettoDto> oggettoDtoList = new ArrayList<>();
			
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
		
		giudizio.setId(dto.getIdGiudizio());
		giudizio.setNumero(dto.getNumeroGiudizio());
		giudizio.setDataApertura(dto.getDataApertura());
		giudizio.setDescrizione(dto.getDescrizione());
		giudizio.setNote(dto.getNote());
		giudizio.setTestoQuesito(dto.getTestoQuesito());
		giudizio.setRiferimentoAtto(dto.getRiferimentoAtto());
		
		
		if ( !ValidationUtil.isNull(dto.getSezione()) && !ValidationUtil.isNullOrZero(dto.getSezione().getIdSezione()) ) {
			giudizio.setIdSezione(dto.getSezione().getIdSezione());
		}
		// -- Categoria (Obbligatorio)
		Categoria categoria = CategoriaAssembler.disassembleDto(dto.getCategoria());
		giudizio.setCategoria(categoria);
		// -- Tipo (Obbligatorio)
		Tipo tipo = TipoAssembler.disassembleDto(dto.getTipo());
		giudizio.setTipo(tipo);
		// -- Tipologia
		if ( !ValidationUtil.isNull(dto.getTipologia()) && !ValidationUtil.isBlankOrNullOrZero(dto.getTipologia().getIdTipologia()) ) {
			Tipologia tipologia = TipologiaAssembler.disassembleDto(dto.getTipologia());
			giudizio.setTipologia(tipologia);
		}
		// -- Lista Oggetti
		if ( !ValidationUtil.isNullOrEmpty(dto.getOggetti()) ) {
			List<Oggetto> oggettoList = new ArrayList<>();
			
			for ( OggettoDto oggettoDto : dto.getOggetti() ) {
				Oggetto oggetto = OggettoAssembler.disassembleDto(oggettoDto);
				oggettoList.add(oggetto);
			}
			
			giudizio.setListaOggetti(oggettoList);
		}
		
		return giudizio;
	}
	
	
}
