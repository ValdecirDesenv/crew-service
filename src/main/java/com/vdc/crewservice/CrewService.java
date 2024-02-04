package com.vdc.crewservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrewService {
    @Autowired
    private final CrewRespository crewRespository;
    @Cacheable("crew")
    public Crew getCrewById(long id){
        return crewRespository.findById(id).orElseThrow(()->new CrewNotFoundException());
    }
}
