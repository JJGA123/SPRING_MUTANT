package com.mutant.contoller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mutant.model.RequestDto;
import com.mutant.model.ResponseDto;
import com.mutant.service.DNAService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DNAController {

    private final DNAService DNAService;

    public DNAController(DNAService DNAService){
        this.DNAService = DNAService;
    }

    /**
     * This method allows to validate if a DNA belongs to a mutant
     * @param dna object with information for validations
     * @return a ResponseEntity<ResponseDTO> with the data found
     */
    @PostMapping(value = {"mutant"},produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(description = "Service that validates a DNA",
            summary = "Validate DNA")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "403", description = "Something happened", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @ResponseBody
    public ResponseEntity<ResponseDto> mutant(@RequestBody(description = "Object with information for validations", required = true,content = @Content(schema=@Schema(implementation = RequestDto.class)))
                                               @org.springframework.web.bind.annotation.RequestBody RequestDto dna) throws JsonProcessingException {
        return ResponseEntity.ok(DNAService.isMutant(dna));
    }

    /**
     * This method gets statistics DNA
     * @return a ResponseEntity<ResponseDTO> with the data found
     */
    @GetMapping(value = {"stats"},produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(description = "Service that gets statistics DNA",
            summary = "Gets statistics DNA")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "403", description = "Something happened", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @ResponseBody
    public ResponseEntity<ResponseDto> stats(){
        return ResponseEntity.ok(DNAService.statisticsDNA());
    }
}
