package com.vdc.crewservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class CrewControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CrewService crewService;

    @Test
    void getCrew_forSavedCrew_isReturned() throws Exception {
        //given
        given(crewService.getCrewById(anyLong())).willReturn(
            Crew.builder()
                    .id(1l)
                    .name("Mark")
                    .duration(10)
                    .build()
        );


        //when//then
        mockMvc.perform(get("/crew/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1l))
                .andExpect(jsonPath("name").value("Mark"))
                .andExpect(jsonPath("duration").value(10));


    }

    @Test
    void getCrew_forMissingStudent_status404() throws Exception {
        //given
        given(crewService.getCrewById(anyLong())).willThrow(CrewNotFoundException.class);

        //when //then
        mockMvc.perform(get("/crew/1"))
                .andExpect(status().isNotFound());

    }
}
