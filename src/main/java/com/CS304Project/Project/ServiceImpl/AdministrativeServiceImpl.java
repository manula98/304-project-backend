package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.AdministrativeDTO;
import com.CS304Project.Project.Entity.Administrative;
import com.CS304Project.Project.Repository.AdministrativeRepository;
import com.CS304Project.Project.Service.AdministrativeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
@Service
public class AdministrativeServiceImpl implements AdministrativeService {

    @Autowired
    private AdministrativeRepository administrativeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AdministrativeDTO> getAllAdministrative() {
        try{
            List<Administrative> administratives = administrativeRepository.findAll();

            if(administratives == null){
                return null;

            }else{
                return modelMapper.map(administratives, new TypeToken<List<AdministrativeDTO>>(){}.getType());
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public AdministrativeDTO addAdministrative(AdministrativeDTO administrativeDTO) throws NoSuchAlgorithmException {
        try{
            Administrative administrative = modelMapper.map(administrativeDTO, Administrative.class);
            Administrative addAdministrative = administrativeRepository.save(administrative);

            return modelMapper.map(addAdministrative, new TypeToken<AdministrativeDTO>(){}.getType());
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public AdministrativeDTO updateAdministrative(AdministrativeDTO administrativeDTO) {
        try{
            AdministrativeDTO administrativeDTO1 = getAdministrativeById(administrativeDTO.getAdminId());

            if(administrativeDTO1 != null){
                Administrative administrative = administrativeRepository.updateAdministrative(administrativeDTO.getEmail(), administrativeDTO.getContactPerson(), administrativeDTO.getTelephone(), administrativeDTO.getAdminId());

                return modelMapper.map(administrative, new TypeToken<AdministrativeDTO>(){}.getType());
            }
            return null;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public AdministrativeDTO getAdministrativeById(int adminId) {
        try{
            Administrative administrative = administrativeRepository.getAdministrativeById(adminId);

            if(administrative != null){
                return modelMapper.map(administrative, new TypeToken<AdministrativeDTO>(){}.getType());
            }
            return null;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteAdministrative(int adminId) {
        boolean delete = false;
        try{
            AdministrativeDTO administrativeDTO = getAdministrativeById(adminId);

            if(administrativeDTO != null){
                administrativeRepository.deleteById(adminId);
                delete = true;
            }
            return delete;
        }catch (Exception e){
            System.out.println(e.toString());
            return delete;
        }
    }
}
