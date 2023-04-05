package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Category c set c.categoryNane = ?1, c.categoryId = ?2", nativeQuery = true)
    Category updateCategory(String categoryName,int categoryId);

    @Query(value = "SELECT * FROM resource_allocation.category WHERE category_id = ?1 LIMIT 1", nativeQuery = true)
    Category getCategoryById(@Param(value = "categoryId")int categoryId);
}
