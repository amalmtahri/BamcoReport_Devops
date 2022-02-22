package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.interfaces.RejectsByDate;
import com.application.bamcoreport.DTO.interfaces.RejectsByType;
import com.application.bamcoreport.DTO.models.RejectCountbyUser;
import com.application.bamcoreport.DTO.models.RejetDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Rejet;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.RejetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RejetService implements IRejetService{

    @Autowired
    private RejetRepository repository;

    @Autowired
    IMapClassWithDto<Rejet, RejetDto> rejetMapping;

    @Autowired
    private UserService userService;

    @Override
    public List<RejetDto> getRejets() {
        List<Rejet> rejets = repository.findAll();
        List<RejetDto> rejetDtos = rejetMapping.convertListToListDto(rejets,RejetDto.class);
        return rejetDtos;
    }

    public RejetDto saveRejet(RejetDto rejetDto){
        // convert DTO to entity
        Rejet rejetRequest = rejetMapping.convertToEntity(rejetDto,Rejet.class);
        User getUserData = userService.getUserById(rejetRequest.getTakenBy().getId());
        rejetRequest.setTakenBy(getUserData);
        log.info("Saving new Rejet {} to database",rejetRequest.getId());
        Rejet rejet = repository.save(rejetRequest);
        // convert entity to DTO
        RejetDto rejetResponse = rejetMapping.convertToDto(rejet, RejetDto.class);
        return rejetResponse;
    }

    public RejetDto getRejetById(Long id){
        Rejet getOne = repository.findById(id).orElse(null);
        RejetDto response = rejetMapping.convertToDto(getOne,RejetDto.class);
        return response;
    }

    public String deleteRejet(Long id){
        repository.deleteById(id);
        return "Rejet removed !!";
    }

    public RejetDto updateRejet(RejetDto rejetDto){
        Rejet rejet = rejetMapping.convertToEntity(rejetDto,Rejet.class);
        Rejet existingRejet = repository.findById(rejet.getId()).orElse(null);
        if(existingRejet!=null){
            User user = userService.getUserById(rejet.getTakenBy().getId());
            rejet.setTakenBy(user);
            Rejet rejet1 =  repository.save(rejet);
            return rejetMapping.convertToDto(rejet1, RejetDto.class);
        }
        return rejetMapping.convertToDto(rejet, RejetDto.class);
    }

    public List<RejectCountbyUser> getRejetctCountByUser(){
        return repository.countTotalRejectsByUser();
    }

    public long rejectsCount(){
        return repository.count();
    }

    public List<RejectsByType> getRejetctCountByType(){
        return repository.countTotalRejectsByTypeAndDate();
    }
    public List<RejectsByDate> getRejetctCountByDate(){
        return repository.countTotalRejectsByDate();
    }
}

