package com.application.bamcoreport.DTO.interfaces;

import java.sql.Timestamp;

public interface RejectsByDate {

    Timestamp getDate();
    long getTotalRejects();
}
