package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Resource r set r.resourceName = ?1, r.description = ?2, r.staffAvalibility = ?3, r.studentAvalibility = ?4, r.publicAvalibility = ?5 where r.resourceId = ?6 LIMIT 1 ",nativeQuery = true)
    Resource updateResource(String resourceName, String description, boolean staffAvalibility, boolean studentAvalibility, boolean publicAvalibility, int resourceId);
    @Query(value = "SELECT * FROM resource_allocation.resource WHERE resource_id = ?1 LIMIT 1",nativeQuery = true)
    Resource getResourceById(@Param(value = "resourceId")int resourceId);
}
