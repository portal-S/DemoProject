package com.ntiteam.demoProject.controller;

import com.ntiteam.demoProject.model.Overlord;
import com.ntiteam.demoProject.service.interfaces.OverlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/overlords/")
public class OverlordControllerV1 {

    @Autowired
    private OverlordService service;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Overlord> createOverlord(@RequestBody Overlord overlord){
        if (overlord == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Overlord savedLord = service.addLord(overlord);
        return new ResponseEntity<>(savedLord, HttpStatus.CREATED);
    }

    @RequestMapping(value = "lazy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Overlord>> getLazyLords(){
        List<Overlord> overlordList = service.getLazyLords();
        if(overlordList == null && overlordList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(overlordList, HttpStatus.OK);
    }

    @RequestMapping(value = "young", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Overlord>> getYoungLords(){
        List<Overlord> overlordList = service.getYoungLords();
        if(overlordList == null && overlordList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(overlordList, HttpStatus.OK);
    }
}
