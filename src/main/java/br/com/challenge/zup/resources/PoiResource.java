package br.com.challenge.zup.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.challenge.zup.model.POI;
import br.com.challenge.zup.services.PoiService;

@RestController
@RequestMapping(value = "/poi")
public class PoiResource {

	@Autowired
	private PoiService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<POI>> findAll() {
		List<POI> listAll = service.findAll();

		return ResponseEntity.ok().body(listAll);
	}

	
	@RequestMapping(value = "/findByProximity", method = RequestMethod.GET)
	public ResponseEntity<List<POI>> findByProximity(
			@RequestParam(value = "x", defaultValue = "1") Integer x,
			@RequestParam(value = "y", defaultValue = "1") Integer y,
			@RequestParam(value = "distance", defaultValue = "1") Integer distance) {
		List<POI> listAll = service.findAll();
		List<POI> listReturn = new ArrayList<POI>();
		
		for(POI obj : listAll) {
			double euclidiana = Math.sqrt(Math.pow((obj.getX() - x),2) + Math.pow((obj.getY() - y),2));
			if(euclidiana <= distance) {
				listReturn.add(obj);
			}
		}
		return ResponseEntity.ok().body(listReturn);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody POI obj) {
		POI objResponse = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objResponse.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}