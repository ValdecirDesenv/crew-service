package com.vdc.crewservice;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void crewNotFoundException(CrewNotFoundException e){

    }
}
