package com.CS304Project.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeedbackDTO {
    private int feedbackId;
    private int ratingScore;
    private String feedbackText;
    private int userId;
    private int resourceId;
}
