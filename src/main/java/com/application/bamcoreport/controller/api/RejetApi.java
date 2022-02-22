package com.application.bamcoreport.controller.api;


import com.application.bamcoreport.DTO.models.RejetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "rejets", description = "the Rejet API")
public interface RejetApi {
    @PostMapping("/addRejet")
    @Operation(summary = "Add a new rejet", description = "This method for added rejet", tags = { "rejets" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "object rejet invalid")
    })
    RejetDto addRejet(@RequestBody RejetDto rejetDto);

    @GetMapping("/getOne/{id}")
    @Operation(summary = "Get rejet by id", description = "search with id rejet", tags = { "rejets" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Rejet with this id is found"),
            @ApiResponse(responseCode  = "404", description = "Rejet with this ID is not found")
    })
    RejetDto getRejetById(@PathVariable Long id);

    @GetMapping("/allRejet")
    @Operation(summary = "Get all rejets", description = "this method return a list of rejet dto", tags = { "rejets" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<RejetDto>> getAllRejets();

    @DeleteMapping("/deleteRejet/{id}")
    @Operation(summary = "Delete rejet", description = "Delete rejet with id", tags = { "rejets" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Rejet deleted"),
    })
    String deleteRejet(@PathVariable Long id);

    @PutMapping("/updateRejet")
    @Operation(summary = "update rejet", description = "update data of rejet", tags = { "rejets" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Rejet updated"),
    })
    RejetDto updateRejet(@RequestBody RejetDto rejetDto);
}
