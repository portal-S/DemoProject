package com.ntiteam.demoProject.service.interfaces;

import com.ntiteam.demoProject.model.Planet;
import com.ntiteam.demoProject.repository.PlanetRepository;

public interface PlanetService {

    public Planet getById(int id);

    public Planet addPlanet(Planet planet);

    public void addLordPlanet(int lord_id, int planet_id);

    public void planetDelete(int id);

}
