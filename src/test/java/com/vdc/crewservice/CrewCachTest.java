package com.vdc.crewservice;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
public class CrewCachTest {
    @Autowired
    private CrewService crewService;

    @MockBean
    private CrewRespository crewRespository;

    @Test
    void getCrewById_forMultipleRequests_isRetrievedFromCach()
    {
        //given
        Long id = 123l;
        given(crewRespository.findById(id)).willReturn(Optional.of(new Crew(id, "Mark")));

        //when
        crewService.getCrewById(id);
        crewService.getCrewById(id);
        crewService.getCrewById(id);

        //Then
        then(crewRespository).should(times(1)).findById(id);
    }
}
