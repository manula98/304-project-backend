package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.AdministrativeDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface AdministrativeService {
    List<AdministrativeDTO> getAllAdministrative();
    AdministrativeDTO addAdministrative(AdministrativeDTO administrativeDTO) throws NoSuchAlgorithmException;
    AdministrativeDTO updateAdministrative(AdministrativeDTO administrativeDTO);
    AdministrativeDTO getAdministrativeById(int adminId);
    boolean deleteAdministrative(int adminId);
}
