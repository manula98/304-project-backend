package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.MultimediaDTO;
import com.CS304Project.Project.Entity.Multimedia;
import com.CS304Project.Project.Repository.MultimediaRepository;
import com.CS304Project.Project.Service.MultimediaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
@Service
public class MultimediaServiceImpl implements MultimediaService {
    @Autowired
    private MultimediaRepository multimediaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<MultimediaDTO> getAllMultimedia() {
        try{
            List<Multimedia> multimediaList = multimediaRepository.findAll();

            if(multimediaList == null){
                return null;

            }else{
                return modelMapper.map(multimediaList, new TypeToken<List<MultimediaDTO>>(){
                }.getType());
            }
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public MultimediaDTO addMultimedia(MultimediaDTO multimediaDTO) throws NoSuchAlgorithmException {
        try{
            Multimedia multimedia = modelMapper.map(multimediaDTO,Multimedia.class);
            Multimedia addMultimedia = multimediaRepository.save(multimedia);

            return modelMapper.map(multimedia, new TypeToken<MultimediaDTO>(){}.getType());
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public MultimediaDTO updateMultimedia(MultimediaDTO multimediaDTO) {
        try{
            MultimediaDTO validMultimedia = getMultimediaById(multimediaDTO.getMultimediaId());

            if(validMultimedia != null){
                Multimedia multimedia = multimediaRepository.updateMultimedia(multimediaDTO.getMultimediaPath(), multimediaDTO.getAlternativeText(), multimediaDTO.getMultimediaId());

                return modelMapper.map(multimedia, new TypeToken<MultimediaDTO>(){}.getType());

            }else{
                return null;
            }
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public MultimediaDTO getMultimediaById(int multimediaId) {
        try{
            Multimedia multimedia = multimediaRepository.getMultimediaById(multimediaId);
            if(multimedia != null){
                return modelMapper.map(multimedia, new TypeToken<MultimediaDTO>(){}.getType());
            }else{
                return null;
            }
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteMultimedia(int multimediaId) {
        boolean delete = false;
        try{
            MultimediaDTO multimedia = getMultimediaById(multimediaId);
            if (multimedia != null){
                multimediaRepository.deleteById(multimediaId);
                delete = true;
            }
            return delete;
        }catch(Exception e){
            System.out.println(e.toString());
            return delete;
        }
    }
}
