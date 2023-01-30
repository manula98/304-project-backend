package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update User u set u.fname = ?1, u.lname = ?2, where u.userId = ?3 ", nativeQuery = true)
    User updateUser(String fname, String lname, int userId);

    @Query(value = "SELECT * FROM resource_allocation.user WHERE userId = ?1 LIMIT = 1", nativeQuery = true)
    User getUserById(@Param(value="userId") int userId);

}
