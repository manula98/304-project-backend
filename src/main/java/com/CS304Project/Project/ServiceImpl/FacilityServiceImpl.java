package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.FacilityDTO;
import com.CS304Project.Project.Entity.Facility;
import com.CS304Project.Project.Repository.FacilityRepository;
import com.CS304Project.Project.Service.FacilityService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FacilityDTO> getAllFacility() {
        try{
            List<Facility> facilities = facilityRepository.findAll();

            if(facilities == null){
                return null;
            }else{
                return modelMapper.map(facilities, new TypeToken<List<FacilityDTO>>(){}.getType());
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public FacilityDTO addFacility(FacilityDTO facilityDTO) throws NoSuchAlgorithmException {
        try{
            Facility facility = modelMapper.map(facilityDTO, Facility.class);
            Facility addFacility = facilityRepository.save(facility);

            return modelMapper.map(addFacility, new TypeToken<FacilityDTO>(){}.getType());
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public FacilityDTO updateFacility(FacilityDTO facilityDTO) {
        try{
            FacilityDTO validFacility = getFacilityById(facilityDTO.getFacilityId());

            if(validFacility != null){
                Facility facility = facilityRepository.updateFacility(facilityDTO.getFacilityType(), facilityDTO.getFacilityId());
                return modelMapper.map(facility, new TypeToken<FacilityDTO>(){}.getType());
            }
            return null;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public FacilityDTO getFacilityById(int facilityId) {
        try{
            Facility facility = facilityRepository.getFacilityById(facilityId);

            if(facility != null){
                return modelMapper.map(facility, new TypeToken<FacilityDTO>(){}.getType());
            }
            return null;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteFacility(int facilityId) {
        boolean delete = false;
        try{
            FacilityDTO facilityDTO = getFacilityById(facilityId);

            if(facilityDTO != null){
                facilityRepository.deleteById(facilityId);
                delete = true;
            }
            return delete;
        }catch (Exception e){
            System.out.println(e.toString());
            return delete;
        }
    }
}
