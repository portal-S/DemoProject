package com.ntiteam.demoProject.service;

import com.ntiteam.demoProject.model.Overlord;
import com.ntiteam.demoProject.model.Planet;
import com.ntiteam.demoProject.repository.PlanetRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanetServiceImplTest {

    @Autowired
    PlanetServiceImpl planetService;

    @MockBean
    PlanetRepository repository;

    @Test
    void getById() {
        Planet planet = new Planet();
        planet.setName("Test");
        Mockito.when(repository.getById(1)).thenReturn(planet);
        Assert.assertEquals(planetService.getById(1), planet);
    }

    @Test
    void addPlanet() {
        planetService.addLordPlanet(1, 2);
        Mockito.verify(repository, Mockito.times(1)).addLordPlanet(1, 2);
    }


    @Test
    void planetDelete() {
        planetService.planetDelete(1);
        Mockito.verify(repository, Mockito.times(1)).deleteById(1);
    }
}