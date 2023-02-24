package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Facility f set f.facilityType = ?1 where f.facilityId = ?2", nativeQuery = true)
    Facility updateFacility(String facilityType, int facilityId);

    @Query(value = "SELECT * FROM resource_allocation.facility WHERE facility_id = ?1 LIMIT 1", nativeQuery = true)
    Facility getFacilityById(@Param(value = "facilityId") int facilityId);
}
