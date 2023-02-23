package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.ResorceDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface ResourceService {

    List<ResorceDTO> getAllResources();
    ResorceDTO addResource(ResorceDTO resorceDTO) throws NoSuchAlgorithmException;
    ResorceDTO getResourceById(int resourceId);
    ResorceDTO updateResource(ResorceDTO resorceDTO);
    boolean deleteResource(int resourceId);

}
