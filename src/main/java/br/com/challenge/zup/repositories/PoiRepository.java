package br.com.challenge.zup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.zup.model.Poi;

public interface PoiRepository extends JpaRepository<Poi, Integer>{ 

	
}