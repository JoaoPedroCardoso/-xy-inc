package br.com.challenge.zup.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.challenge.zup.model.Poi;
import br.com.challenge.zup.services.PoiService;

@RestController
@RequestMapping(value = "/poi")
public class PoiResource {

	@Autowired
	private PoiService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Poi>> findAll() {
		List<Poi> listAll = service.findAll();

		return ResponseEntity.ok().body(listAll);
	}

	
	@RequestMapping(value = "/findByProximity", method = RequestMethod.GET)
	public ResponseEntity<List<Poi>> findByProximity(
			@RequestParam(value = "x", defaultValue = "1") Integer x,
			@RequestParam(value = "y", defaultValue = "1") Integer y,
			@RequestParam(value = "distance", defaultValue = "1") Integer distance) {
		List<Poi> listAll = service.findAll();
		List<Poi> listReturn = new ArrayList<Poi>();
		
		for(Poi obj : listAll) {
			double euclidiana = Math.sqrt(Math.pow((obj.getX() - x),2) + Math.pow((obj.getY() - y),2));
			if(euclidiana <= distance) {
				listReturn.add(obj);
			}
		}
		return ResponseEntity.ok().body(listReturn);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Poi obj) {
		Poi objResponse = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objResponse.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}