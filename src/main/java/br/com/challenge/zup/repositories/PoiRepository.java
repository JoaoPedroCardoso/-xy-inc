package br.com.challenge.zup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.zup.model.POI;

public interface PoiRepository extends JpaRepository<POI, Integer>{ 


}