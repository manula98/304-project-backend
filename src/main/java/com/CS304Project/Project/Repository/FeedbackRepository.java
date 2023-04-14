package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Feedback f set f.ratingScore = ?1, f.feedbackText = ?2 where f.feedbackId = ?3", nativeQuery = true)
    Feedback updateFeedback(int ratingScore, String feedbackText, int feedbackId);

    @Query(value = "SELECT * FROM resource_allocation.feedback WHERE feedback_id = ?1 LIMIT 1", nativeQuery = true)
    Feedback getFeedbackById(@Param(value = "feedbackId") int feedbackId);

    @Query(value = "SELECT * FROM resource_allocation.feedback WHERE resource_id = ?1", nativeQuery = true)
    List<Feedback> getFeedbackByResourceId(@Param(value = "resourceId") int resourceId);
}
