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

/**
 * Service Entità <em>it.corteconti.sisp.sample.model.Giudizio</em> 
 * @version 1.0
 */

@Service
@Transactional
public class GiudizioService {
	
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
		
		// -- Verifica valorizzazione oggetto
		if(giudizio == null) {
			// logging	
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Giudizio {0} not found.", id));
		}
		
		// logging	
		LOG.debug(MessageFormat.format("Trovato il seguente giudizio: {0}", giudizio.getDescrizione()));
		
		// -- Assembler, Giudizio -> GiudizioDto			
		return GiudizioAssembler.assembleDto(giudizio);
	}
	
	
	public GiudizioDto save(GiudizioDto dto) {
		
		// -- TODO IMPLEMENTARE VALIDAZIONE !!!
		
		/* Recupero del NUMERO in base alla Sezione
		 * NUMERO -> 'VALORE_CONTATORE' (Tabella 'CONTATORI')
		 */
		Long numero;
		Sezione sezione = this.sezioneRepository.findOne(dto.getSezioneDto().getIdSezione());
		
		Contatore contatore = sezione.getContatori().get(0);
		numero = contatore.getValoreContatore();
		numero++;
		
		// -- Update Contatore (incremento di uno il valore del contatore)
		Contatore contatoreDb = this.contatoreRepository.findOne(contatore.getCodiceContatore());
		contatoreDb.setValoreContatore(numero);
		
		// -- dto -> entità
		Giudizio giudizio = GiudizioAssembler.disassembleDto(dto);
		// -- NUMERO
		giudizio.setNumero(numero);
		// -- Tipologiche
//		if ( giudizio.getCategoria() != null && giudizio.getCategoria().getCodiceCategoria() != null )
//			giudizio.setCategoria(this.categoriaRepository.findOne(giudizio.getCategoria().getCodiceCategoria()));
//		if ( giudizio.getTipo() != null && giudizio.getTipo().getCodiceTipo() != null )
//			giudizio.setTipo(this.tipoRepository.findOne(giudizio.getTipo().getCodiceTipo()));
//		if ( giudizio.getTipologia() != null && giudizio.getTipologia().getCodiceTipologia() != null )
//			giudizio.setTipologia(this.tipologiaRepository.findOne(giudizio.getTipologia().getCodiceTipologia()));
//		// -- Lista Oggetto
		List<Oggetto> ret = new ArrayList<Oggetto>();
		if ( giudizio.getListaOggetti() != null && giudizio.getListaOggetti().size() > 0 ) {
			
			for ( Oggetto oggetto : giudizio.getListaOggetti() ) {
				oggetto = this.oggettoRepository.findOne(oggetto.getCodiceOggetto());
				ret.add(oggetto);
			}
			giudizio.setListaOggetti(ret);
		}
		
		// -- Save
		Giudizio giudizioNew = this.giudizioRepository.save(giudizio);
		giudizioNew.setListaOggetti(ret);
		// -- Ritorno dto
		return GiudizioAssembler.assembleDto(giudizioNew);
	}
	
}
