package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.MultimediaDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface MultimediaService {
    List<MultimediaDTO> getAllMultimedia();
    MultimediaDTO addMultimedia(MultimediaDTO multimediaDTO) throws NoSuchAlgorithmException;
    MultimediaDTO updateMultimedia(MultimediaDTO multimediaDTO);
    MultimediaDTO getMultimediaById(int multimediaId);
    boolean deleteMultimedia(int multimediaId);
}
