package com.mutant.unitTest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mutant.model.RequestDto;
import com.mutant.model.ResponseDto;
import com.mutant.service.DNAService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DNAControllerTest {

    @InjectMocks
    com.mutant.contoller.DNAController DNAController;

    @Mock
    DNAService DNAService;

    /**
     * This method testing end point mutant
     * Validate that response is not null.
     */
    @Test
    void mutantTest() throws JsonProcessingException {
        when(DNAService.isMutant(any(RequestDto.class))).then(new Answer<ResponseDto>() {
            @Override
            public ResponseDto answer(InvocationOnMock invocation) throws Throwable {
                return ResponseDto.builder().status(HttpStatus.OK.toString()).details("Details Test").errors(null).objects(null).build();
            }
        });
        assertNotNull(DNAController.mutant(RequestDto.builder().dna(any()).build()));
    }

    /**
     * This method testing end point stats
     * Validate that response is not null.
     */
    @Test
    void statsTest() throws JsonProcessingException {
        when(DNAService.statisticsDNA()).then(new Answer<ResponseDto>() {
            @Override
            public ResponseDto answer(InvocationOnMock invocation) throws Throwable {
                return ResponseDto.builder().status(HttpStatus.OK.toString()).details("Details Test").errors(null).objects(null).build();
            }
        });
        assertNotNull(DNAController.stats());
    }

}
