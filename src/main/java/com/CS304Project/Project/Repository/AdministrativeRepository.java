package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.Administrative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdministrativeRepository extends JpaRepository<Administrative, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Administrative a set a.email = ?1, a.contactPerson = ?2, a.telephone = ?3 where a.adminId", nativeQuery = true)
    Administrative updateAdministrative(String email, String contactPerson, String telephone, int adminId);

    @Query(value = "SELECT * FROM resource_allocation.administrative WHERE admin_id = ?1 LIMIT 1", nativeQuery = true)
    Administrative getAdministrativeById(@Param(value = "adminId") int adminId);
}
