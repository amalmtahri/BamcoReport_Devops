package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.interfaces.RejectsByDate;
import com.application.bamcoreport.DTO.interfaces.RejectsByType;
import com.application.bamcoreport.DTO.models.RejectCountbyUser;
import com.application.bamcoreport.controller.api.DashApi;
import com.application.bamcoreport.service.RejetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dash")
public class DashController implements DashApi {

    @Autowired
    private RejetService service;

    @Override
    public ResponseEntity<List<RejectCountbyUser>> usersRejectsCount(){
        List<RejectCountbyUser> rejectCountbyUsers = service.getRejetctCountByUser();
        return ResponseEntity.ok(rejectCountbyUsers);

    }

    @Override
    public long  rejectCount(){
        return service.rejectsCount();
    }

    @Override
    public ResponseEntity<List<RejectsByType>>  rejectCountByType(){
        List<RejectsByType> rejectCountbyType = service.getRejetctCountByType();
        return ResponseEntity.ok(rejectCountbyType);
    }

    @Override
    public ResponseEntity<List<RejectsByDate>>  rejectCountByDate(){
        List<RejectsByDate> rejectCountbyType = service.getRejetctCountByDate();
        return ResponseEntity.ok(rejectCountbyType);
    }
}
