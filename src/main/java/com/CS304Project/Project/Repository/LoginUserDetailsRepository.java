package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.LoginUserDetails;
import com.CS304Project.Project.Entity.User;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LoginUserDetailsRepository extends JpaRepository<LoginUserDetails,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update LoginPassword l set l.passoword = ?1 where l.loginId = ?2", nativeQuery = true)
    int updateLoginPassword(String password,int loginId);
    @Query(value = "SELECT * FROM resource_allocation.login_user_details WHERE email =?1",nativeQuery = true)
    LoginUserDetails validateEmail(String email);
    @Query(value = "SELECT * FROM resource_allocation.login_user_details WHERE loginId =?1",nativeQuery = true)
    LoginUserDetails getLoginUserDetailsById(int loginId);

    @Query(value = "SELECT * FROM resource_allocation.login_user_details WHERE email=?1 LIMIT 1", nativeQuery = true)
    Optional<LoginUserDetails> findByEmail(String email);

    @Query(value = "SELECT * FROM resource_allocation.login_user_details WHERE userId=?1 LIMIT 1", nativeQuery = true)
    LoginUserDetails getEmailByUserId(int userId);
    @Query(value = "SELECT * FROM resource_allocation.login_user_details WHERE loginId = ?1 LIMIT 1",nativeQuery = true)
    LoginUserDetails getEmailByLoginId(int loginId);
}
