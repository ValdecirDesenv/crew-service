package com.vdc.crewservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CrewRespository extends JpaRepository<Crew, Long> {
    Crew getCrewByName(String name);

    @Query("Select avg(duration) from Crew where active=true ")
    Double getAvgGradeForActiveCrew();
}
