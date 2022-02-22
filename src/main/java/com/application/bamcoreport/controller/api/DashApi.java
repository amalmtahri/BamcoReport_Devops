package com.application.bamcoreport.controller.api;

import com.application.bamcoreport.DTO.interfaces.RejectsByDate;
import com.application.bamcoreport.DTO.interfaces.RejectsByType;
import com.application.bamcoreport.DTO.models.RejectCountbyUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name = "dash", description = "dashboard API")
@SecurityRequirement(name = "bearerAuth")
public interface DashApi {

    @GetMapping("/reject/count/users")
    @Operation(summary = "Get rejects count by users", description = "this method return a list of rejects count by users ", tags = { "rejects_users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<RejectCountbyUser>> usersRejectsCount();


    @GetMapping("/reject/count")
    @Operation(summary = "Get rejects count", description = "this method return a list of rejects count", tags = { "rejects" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    long  rejectCount();


    @GetMapping("/reject/count/type")
    @Operation(summary = "Get rejects count by  type", description = "this method return a list of rejects count by  type", tags = { "rejects" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<RejectsByType>>  rejectCountByType();


    @GetMapping("/reject/count/date")
    @Operation(summary = "Get rejects count by date ", description = "this method return a list of rejects count by date ", tags = { "rejects" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<RejectsByDate>>  rejectCountByDate();
}
