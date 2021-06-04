package com.ntiteam.demoProject.controller;

import com.ntiteam.demoProject.model.Planet;
import com.ntiteam.demoProject.service.interfaces.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/planets/")
public class PlanetControllerV1 {

    @Autowired
    private PlanetService service;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Planet> addPlanet(@RequestBody Planet planet){
        if(planet == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Planet savedPlanet = service.addPlanet(planet);
        return new ResponseEntity<>(savedPlanet, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Planet> setLord(@RequestParam(value = "planetId") int planetId, @RequestParam(value = "lordId") int lordId){
        service.addLordPlanet(lordId, planetId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Planet> deletePlanet(@PathVariable("id") int id){
        Planet planet = service.getById(id);
        if(planet == null) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.planetDelete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
