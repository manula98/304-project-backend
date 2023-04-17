package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.Role;
import com.CS304Project.Project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.role = ?1 where u.userId = ?2")
    int changeRole(Role role, int userId);
    @Transactional
    @Modifying
    @Query(value = "update User u set u.fname = ?1, u.lname = ?2, u.telephone = ?3, u.userRole = ?4 where u.userId = ?5 ")
    int updateUser(String fname, String lname, String telephone, String userRole, int userId);

    @Query(value = "SELECT * FROM resource_allocation.user WHERE user_id = ?1 LIMIT 1",nativeQuery = true)
    User getUserById(@Param(value="userId") int userId);

    @Query(value = "SELECT * FROM resource_allocation.user WHERE login_id = ?1 LIMIT 1",nativeQuery = true)
    User getUserByLoginId(@Param(value="loginId") int loginId);

    @Query(value = "SELECT * FROM resource_allocation.user WHERE user_id = (SELECT user_id FROM resource_allocation.login_user_details WHERE email = ?1) LIMIT 1", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT email FROM resource_allocation.login_user_details WHERE login_id = (SELECT login_id FROM resource_allocation.user WHERE user_id = ?1) LIMIT 1", nativeQuery = true)
    String getEmailByUserId(@Param(value = "userId") int userId);

}
