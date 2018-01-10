package br.com.challenge.zup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.zup.model.POI;
import br.com.challenge.zup.repositories.PoiRepository;

@Service
public class PoiService {
	
	@Autowired 
	private PoiRepository repo; 
	
	public List<POI> findAll() {
		return repo.findAll();
	}
	
	public POI insert(POI obj) {
		obj.setId(null); 
		return repo.save(obj); 
	}
	

	public List<POI> findByProximity(Integer x, Integer y, Integer distance) {
		//TODO implements here
		return null;
	}
}
