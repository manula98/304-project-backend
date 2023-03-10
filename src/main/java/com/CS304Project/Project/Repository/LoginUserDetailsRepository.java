package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.LoginUserDetails;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoginUserDetailsRepository extends JpaRepository<LoginUserDetails,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update LoginPassword l set l.passoword = ?1 where l.loginId = ?2", nativeQuery = true)
    void updateLoginPassword(String password,int loginId);
    @Query(value = "SELECT * FROM resource_allocation.login_user_details WHERE email =?1",nativeQuery = true)
    LoginUserDetails validateEmail(String email);
    @Query(value = "SELECT * FROM resource_allocation.LoginUserDetails WHERE loginId =?1",nativeQuery = true)
    LoginUserDetails getLoginUserDetailsById(int loginId);
}
