package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.FacilityDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface FacilityService {
    List<FacilityDTO> getAllFacility();
    FacilityDTO addFacility(FacilityDTO facilityDTO) throws NoSuchAlgorithmException;
    FacilityDTO updateFacility(FacilityDTO facilityDTO);
    FacilityDTO getFacilityById(int facilityId);
    boolean deleteFacility(int facilityId);
}
