package br.com.challenge.zup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.zup.model.Poi;
import br.com.challenge.zup.repositories.PoiRepository;
import br.com.challenge.zup.services.exceptions.RequiredParametersException;

@Service
public class PoiService {
	
	@Autowired 
	private PoiRepository repo; 
	
	public List<Poi> findAll() {
		return repo.findAll();
	}
	
	public Poi insert(Poi obj) {
		obj.setId(null); 
		if(obj.getName() == null) {
			throw new RequiredParametersException("O Parametro name é obrigatorio");
		}
		if(obj.getX() == null) {
			throw new RequiredParametersException("O parametro X é obrigatorio");
		}
			
		if(obj.getY() == null){
			throw new RequiredParametersException("O parametro y é obrigatorio");
		}
		return repo.save(obj); 
	}
	
}
