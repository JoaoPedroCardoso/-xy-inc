package br.com.challenge.zup.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.zup.model.POI;
import br.com.challenge.zup.repositories.PoiRepository;

@Service
public class DbService {

	@Autowired
	private PoiRepository poirepository;
	
	public void instantiateTestDatabase() throws ParseException {

		POI lanchonete = new POI(null, "Lanchonete", 27, 12);
		POI posto = new POI(null, "Posto", 31, 18);
		POI joalheria = new POI(null, "Joalheria", 15, 18);
		POI floricultura = new POI(null, "Floricultura", 19, 21);
		POI pub = new POI(null, "Pub", 12, 8);
		POI supermecado = new POI(null, "Supermercado", 23, 6);
		POI churrascaria = new POI(null, "Churrascaria", 28, 2);
		
		poirepository.save(Arrays.asList(lanchonete,posto,joalheria,floricultura,pub,supermecado,churrascaria));
	}

}
