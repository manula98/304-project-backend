package com.CS304Project.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResorceDTO {

    private int resourceId;

    private String resourceName;

    private String description;

    private boolean staffAvalibility;

    private boolean studentAvalibility;

    private boolean publicAvalibility;
    private int categoryId;

}
