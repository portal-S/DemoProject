package com.ntiteam.demoProject.service;

import com.ntiteam.demoProject.model.Planet;
import com.ntiteam.demoProject.repository.PlanetRepository;
import com.ntiteam.demoProject.service.interfaces.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository repository;


    @Override
    public Planet getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Planet addPlanet(Planet planet) {
        return repository.save(planet);
    }

    @Override
    public void addLordPlanet(int lord_id, int planet_id) {
        repository.addLordPlanet(lord_id, planet_id);
    }

    @Override
    public void planetDelete(int id) {
        repository.deleteById(id);;
    }
}
