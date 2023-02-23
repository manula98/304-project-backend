package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Multimedia m set m.multimediaPath = ?1, m.alternativeText = ?2 where m.multimediaId = ?3",nativeQuery = true)
    Multimedia updateMultimedia(String multimeadiaPath, String alternativeText, int multimediaId);

    @Query(value = "SELECT * FROM resource_allocation.multimedia WHERE multimedia_id = ?1 LIMIT 1",nativeQuery = true)
    Multimedia getMultimediaById(@Param(value = "multimediaId")int multimediaId);
}
