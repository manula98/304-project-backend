package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.LoginUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserDetailsRepository extends JpaRepository<LoginUserDetails,Integer> {

}
