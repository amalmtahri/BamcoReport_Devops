package com.application.bamcoreport.repository;

import com.application.bamcoreport.DTO.interfaces.RejectsByDate;
import com.application.bamcoreport.DTO.interfaces.RejectsByType;
import com.application.bamcoreport.DTO.models.RejectCountbyUser;
import com.application.bamcoreport.entity.Rejet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RejetRepository extends JpaRepository<Rejet, Long> {

    @Query(value = "SELECT r.takenby as userid,u.username AS username, COUNT(r.*) AS totalRejects FROM rejets AS r,users  AS u where u.id=r.takenby GROUP BY r.takenby , u.username ", nativeQuery = true)
    List<RejectCountbyUser> countTotalRejectsByUser();

    @Query(value = "SELECT r.rejectnature as type , COUNT(r.*) AS totalRejects FROM rejets as r GROUP BY r.rejectnature ", nativeQuery = true)
    List<RejectsByType> countTotalRejectsByTypeAndDate();


    @Query(value = "SELECT r.declarationdate as date , COUNT(r.*) AS totalRejects FROM rejets as r GROUP BY r.declarationdate ", nativeQuery = true)
    List<RejectsByDate> countTotalRejectsByDate();

}
