package com.CS304Project.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MultimediaDTO {
    private int multimediaId;
    private String multimediaPath;
    private String alternativeText;
    private int resourceId;

}
