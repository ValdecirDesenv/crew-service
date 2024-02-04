package com.vdc.crewservice;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CrewController {

    @Autowired
    private final CrewService crewService;

    @GetMapping("/crew/{id}")
    Crew getCrew(@PathVariable long id)
    {
        return crewService.getCrewById(id);
    }
    @
    void crewNotFoundException(CrewNotFoundException e){

    }
}
