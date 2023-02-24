package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.FeedbackDTO;
import com.CS304Project.Project.Entity.Feedback;
import com.CS304Project.Project.Repository.FeedbackRepository;
import com.CS304Project.Project.Service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<FeedbackDTO> getAllFeedback() {
        try{
            List<Feedback> feedbacks = feedbackRepository.findAll();

            if(feedbacks == null){
                return null;

            }else{
                return modelMapper.map(feedbacks, new TypeToken<List<FeedbackDTO>>(){}.getType());
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public FeedbackDTO addFeedback(FeedbackDTO feedbackDTO) throws NoSuchAlgorithmException {
        try{
            Feedback feedback = modelMapper.map(feedbackDTO,Feedback.class);
            Feedback addFeedback = feedbackRepository.save(feedback);

            return modelMapper.map(addFeedback, new TypeToken<FeedbackDTO>(){}.getType());
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public FeedbackDTO updateFeedback(FeedbackDTO feedbackDTO) {
        try{
            FeedbackDTO feedback = getFeedbackById(feedbackDTO.getFeedbackId());

            if(feedback != null){
                Feedback feedback1 = feedbackRepository.updateFeedback(feedback.getRatingScore(), feedbackDTO.getFeedbackText(), feedbackDTO.getFeedbackId());

                return modelMapper.map(feedback1, new TypeToken<FeedbackDTO>(){}.getType());
            }
            return null;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public FeedbackDTO getFeedbackById(int feedbackId) {
        try{
            Feedback feedback = feedbackRepository.getFeedbackById(feedbackId);

            if(feedback != null){
                return modelMapper.map(feedback, new TypeToken<FeedbackDTO>(){}.getType());
            }
            return null;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteFeedback(int feedbackId) {
        boolean delete = false;
        try{
            FeedbackDTO feedbackDTO = getFeedbackById(feedbackId);

            if(feedbackDTO != null){
                feedbackRepository.deleteById(feedbackId);
                delete = true;
            }
            return delete;
        }catch (Exception e){
            System.out.println(e.toString());
            return delete;
        }
    }
}
