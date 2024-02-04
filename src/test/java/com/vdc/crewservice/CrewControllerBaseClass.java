package com.vdc.crewservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@WebMvcTest
public class CrewControllerBaseClass {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CrewService crewService;

    @BeforeEach
    void before() throws Exception {
        RestAssuredMockMvc.mockMvc(mockMvc);
        //given
        given(crewService.getCrewById(anyLong())).willReturn(
                Crew.builder()
                        .id(1l)
                        .name("Mark")
                        .duration(10)
                        .build()
        );



    }
    }
