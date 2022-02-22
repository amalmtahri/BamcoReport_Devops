package com.application.bamcoreport.DTO.models;


import org.springframework.beans.factory.annotation.Value;

public interface RejectCountbyUser {


     long getUserid();
     String getUsername();
     long getTotalRejects();
}
