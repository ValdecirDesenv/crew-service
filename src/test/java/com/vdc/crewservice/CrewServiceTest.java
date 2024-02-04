package com.vdc.crewservice;

import jakarta.transaction.Transactional;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class CrewServiceTest {
    @Autowired
    private CrewRespository crewRespository;
    @Autowired
    private CrewService crewService;
    @DisplayName("Returning saved crew")
    @Test
    void getCrewById_forSavedCrew_isReturned(){
        //given
        Crew saveCrew  = crewRespository.save(new Crew(null,"Pedro"));

        //when
        Crew retrievedCrew = crewService.getCrewById(saveCrew.getId());
        //them
        then(retrievedCrew.getName()).isEqualTo("Pedro");
        then(retrievedCrew.getId()).isNotNull();

    }

    @Test
    void getCrewById_whenMissingStudent_notFoundExceptionThrown()
    {
        //given
        Long id = 1234l;

        //when
        Throwable throwable = catchThrowable(() -> crewService.getCrewById(id));

        //them
        BDDAssertions.then(throwable).isInstanceOf(CrewNotFoundException.class);

    }
}
