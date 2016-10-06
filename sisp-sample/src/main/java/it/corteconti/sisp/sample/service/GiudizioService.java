package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.corteconti.sisp.sample.assembler.GiudizioAssembler;
import it.corteconti.sisp.sample.dao.CategoriaRepository;
import it.corteconti.sisp.sample.dao.ContatoreRepository;
import it.corteconti.sisp.sample.dao.GiudizioRepository;
import it.corteconti.sisp.sample.dao.OggettoRepository;
import it.corteconti.sisp.sample.dao.SezioneRepository;
import it.corteconti.sisp.sample.dao.TipoRepository;
import it.corteconti.sisp.sample.dao.TipologiaRepository;
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Contatore;
import it.corteconti.sisp.sample.model.Giudizio;
import it.corteconti.sisp.sample.model.Oggetto;
import it.corteconti.sisp.sample.model.Sezione;
import it.corteconti.sisp.sample.service.validation.GiudizioValidationService;
import it.corteconti.sisp.util.ValidationUtil;

/**
 * Service Entità <em>it.corteconti.sisp.sample.model.Giudizio</em> 
 * @version 1.0
 */
@Service
@Transactional
public class GiudizioService extends GiudizioValidationService {
	
	private static final Logger LOG = LoggerFactory.getLogger(GiudizioService.class);

	@Autowired
	private GiudizioRepository giudizioRepository;
	@Autowired
	private SezioneRepository sezioneRepository;
	@Autowired
	private ContatoreRepository contatoreRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private TipologiaRepository tipologiaRepository;
	@Autowired
	private OggettoRepository oggettoRepository;
	
	
	/**
	 * <p>Ritorna un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em></p>
	 * @param id	id dell'entità Giudizio
	 * @return		<em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	public GiudizioDto getGiudizio(Long id) {

		// -- Recupero entità Giudizio a fronte dell'id			
		Giudizio giudizio = this.giudizioRepository.findOne(id);
		
		// -- Verifica valorizzazione entità
		if ( giudizio == null ) {
			// logging	
			LOG.debug(MessageFormat.format("Nessun entità Giudizio trovata per Id {0}.", id));
			throw new ResourceNotFoundException(
					MessageFormat.format("Giudizio {0} not found.", id));
		}
		
		// logging	
		LOG.debug(MessageFormat.format("Trovato il seguente giudizio: {0}", giudizio.getDescrizione()));
		
		// -- Assembler, Giudizio -> GiudizioDto
		return GiudizioAssembler.assembleDto(giudizio);
	}
	
	/**
	 * <p>Ritorna un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em></p>
	 * @param numero		contatore
	 * @param idTipo		id dell'entità Tipo
	 * @param idCategoria	id dell'entità Categoria
	 * @return				<em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	public GiudizioDto getByNumeroAndTipoAndCategoria(Long numero, String idTipo, String idCategoria) {
		
		// -- Recupero Giudizio in base a NUMERO-TIPO-CATEGORIA
		Giudizio giudizio = this.giudizioRepository.getByNumeroAndTipoAndCategoria(numero, idTipo, idCategoria);
		
		// -- Verifica valorizzazione entità
		if ( giudizio == null ) {
			// logging	
			LOG.debug(MessageFormat.format("Nessun entità Giudizio trovata per Numero {0}, Tipo {1}, Categoria {2}.", numero, idTipo, idCategoria));
			throw new ResourceNotFoundException(
					MessageFormat.format("Giudizio with Numero {0} and Tipo {1} and Categoria {2} not found.", numero, idTipo, idCategoria));
		}
		
		// -- Assembler, Giudizio -> GiudizioDto
		return GiudizioAssembler.assembleDto(giudizio);
	}
	
	/**
	 * <p>Esegue la creazione dell'entità Giudizio</p>
	 * @param dto 		dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 * @param idSezione	id dell'entità Sezione
	 * @param idAmbito	id dell'entità Ambito
	 * @return			dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	public GiudizioDto save(GiudizioDto dto, Long idSezione, String idAmbito) {
		
		// -- Validazione INPUT/BUSINESS
		this.validationInput(dto);
		this.validationBusiness(dto, idSezione, idAmbito);
		
		/* Recupero del NUMERO in base alla Sezione
		 * NUMERO -> 'VALORE_CONTATORE' (Tabella 'CONTATORI')
		 */
		Long numero;
		Sezione sezione = this.sezioneRepository.findOne(idSezione);
		// logging
		LOG.debug("-- [Sezione] -> [" + sezione.toString() + "]");
		
		Contatore contatore = sezione.getContatori().get(0);
		numero = contatore.getValoreContatore();
		// logging
		LOG.debug("-- [Contatore] -> valore Db [" + numero + "]");
		numero++;
		
		// -- Update Contatore (incremento di uno il valore del contatore)
		Contatore contatoreDb = this.contatoreRepository.findOne(contatore.getCodiceContatore());
		contatoreDb.setValoreContatore(numero);
		
		// -- dto -> entità
		Giudizio giudizio = GiudizioAssembler.disassembleDto(dto);
		// -- NUMERO
		giudizio.setNumero(numero);
		// -- Id Sezione
		giudizio.setIdSezione(idSezione);
		
		// -- Tipologiche
		if ( !ValidationUtil.isNull(giudizio.getCategoria()) && !ValidationUtil.isBlankOrNullOrZero(giudizio.getCategoria().getCodiceCategoria()) ) {
			giudizio.setCategoria(this.categoriaRepository.findOne(giudizio.getCategoria().getCodiceCategoria()));
		}
		if ( !ValidationUtil.isNull(giudizio.getTipo()) && !ValidationUtil.isBlankOrNullOrZero(giudizio.getTipo().getCodiceTipo()) ) {
			giudizio.setTipo(this.tipoRepository.findOne(giudizio.getTipo().getCodiceTipo()));
		}
		if ( !ValidationUtil.isNull(giudizio.getTipologia()) && !ValidationUtil.isBlankOrNullOrZero(giudizio.getTipologia().getCodiceTipologia()) ) {
			giudizio.setTipologia(this.tipologiaRepository.findOne(giudizio.getTipologia().getCodiceTipologia()));
		}
		
		// -- Lista Oggetto
		List<Oggetto> ret = new ArrayList<>();
		if ( !ValidationUtil.isNullOrEmpty(giudizio.getListaOggetti()) ) {
			
			for ( Oggetto oggetto : giudizio.getListaOggetti() ) {
				oggetto = this.oggettoRepository.findOne(oggetto.getCodiceOggetto());
				ret.add(oggetto);
			}
			giudizio.setListaOggetti(ret);
		}
		
		// -- Save
		Giudizio giudizioNew = this.giudizioRepository.save(giudizio);
		// -- Ritorno dto
		return GiudizioAssembler.assembleDto(giudizioNew);
	}
	
}
