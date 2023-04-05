package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.ResorceDTO;
import com.CS304Project.Project.Entity.Resource;
import com.CS304Project.Project.Repository.ResourceRepository;
import com.CS304Project.Project.Service.ResourceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ResorceDTO> getAllResources() {
        try{
            List<Resource> resourceList = resourceRepository.findAll();

            if(resourceList==null){
                return  null;
            }
            return modelMapper.map(resourceList, new TypeToken<List<ResorceDTO>>(){
            }.getType());

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public ResorceDTO addResource(ResorceDTO resorceDTO) throws NoSuchAlgorithmException {
        try{
            Resource resource = modelMapper.map(resorceDTO, Resource.class);
            Resource addReso = resourceRepository.save(resource);
            //return resorceDTO;

            return modelMapper.map(addReso, new TypeToken<ResorceDTO>(){}.getType());

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public ResorceDTO getResourceById(int resourceId) {
        try{
            Resource resource = resourceRepository.getResourceById(resourceId);

            if(resource != null){
                return modelMapper.map(resource, new TypeToken<ResorceDTO>(){
                }.getType());
            }else{
                return null;
            }

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public ResorceDTO updateResource(ResorceDTO resorceDTO) {
        try{
            ResorceDTO validResource = getResourceById(resorceDTO.getResourceId());

            if(validResource != null){
                Resource resource = resourceRepository.updateResource(resorceDTO.getResourceName(), resorceDTO.getDescription(),resorceDTO.isStaffAvalibility(),resorceDTO.isStudentAvalibility(), resorceDTO.isPublicAvalibility() ,resorceDTO.getResourceId());
                return modelMapper.map(resource, new TypeToken<ResorceDTO>(){
                }.getType());
            }else{
                return null;
            }

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteResource(int resourceId) {
        boolean delete = false;
        try{
            ResorceDTO resource = getResourceById(resourceId);

            if(resource != null){
                resourceRepository.deleteById(resourceId);
                delete = true;
            }
            return delete;
        }catch(Exception e){
            System.out.println(e.toString());
            return delete;
        }
    }
}
