package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.RejetDto;
import com.application.bamcoreport.controller.api.RejetApi;
import com.application.bamcoreport.service.RejetService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rejet")
@SecurityRequirement(name = "bearerAuth")
public class RejetController implements RejetApi {

    @Autowired
    private RejetService service;

    @Override
    public RejetDto addRejet(@RequestBody RejetDto rejetDto){
        return service.saveRejet(rejetDto);
    }


    @Override
    public RejetDto getRejetById(@PathVariable Long id){
        return service.getRejetById(id);
    }

    @Override
    public ResponseEntity<List<RejetDto>> getAllRejets(){
        List<RejetDto> rejetDto = service.getRejets();
        return ResponseEntity.ok(rejetDto);
    }

    @Override
    public String deleteRejet(@PathVariable Long id){
        return service.deleteRejet(id);
    }

    @Override
    public RejetDto updateRejet(@RequestBody RejetDto rejetDto){
        return service.updateRejet(rejetDto);
    }


}
