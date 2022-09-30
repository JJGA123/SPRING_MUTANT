package com.mutant.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mutant.model.RequestDto;
import com.mutant.model.ResponseDto;

public interface DNAService {

    ResponseDto isMutant(RequestDto dna) throws JsonProcessingException;
    ResponseDto statisticsDNA();

}
