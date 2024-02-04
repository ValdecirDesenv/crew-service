package com.vdc.crewservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
public class CrewRepositoryTest {
    @Autowired
    private CrewRespository crewRespository;

    @Autowired
    private TestEntityManager testEntityManager;
    @Test
    void testGetCrewByName_returnCrewDetails(){
        //given
        Crew saveCrew = testEntityManager.persistFlushFind(new Crew(null,"Hardware"));
        //Crew saveCrew = crewRespository.save(new Crew(null,"Hardware"));

        //when
        Crew crew = crewRespository.getCrewByName("Hardware");

        //then
        then(crew.getId()).isNotNull();
        then(crew.getName()).isEqualTo(saveCrew.getName());
    }
    @Test
    void getAvgGradeForActiveDurationCrew_calculatesAvg()
    {
        //given
        Crew mark = Crew.builder().name("Mark").active(true).duration(80).build();
        Crew susan = Crew.builder().name("Susan").active(true).duration(100).build();
        Crew peter = Crew.builder().name("Peter").active(false).duration(50).build();
        Arrays.asList(mark, susan, peter).forEach(testEntityManager::persistFlushFind);

        //when
        Double avgDuration = crewRespository.getAvgGradeForActiveCrew();

        //then
        then(avgDuration).isEqualTo(90);
    }
}
