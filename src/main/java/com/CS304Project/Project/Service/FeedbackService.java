package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.FeedbackDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface FeedbackService {
    List<FeedbackDTO> getAllFeedback();
    FeedbackDTO addFeedback(FeedbackDTO feedbackDTO) throws NoSuchAlgorithmException;
    FeedbackDTO updateFeedback(FeedbackDTO feedbackDTO);
    FeedbackDTO getFeedbackById(int feedbackId);
    boolean deleteFeedback(int feedbackId);
    List<FeedbackDTO> getFeedbackByResourceId(int resourceId);
}
