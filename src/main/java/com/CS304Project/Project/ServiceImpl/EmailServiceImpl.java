package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.Repository.ResourceRepository;
import com.CS304Project.Project.Repository.UserRepository;
import com.CS304Project.Project.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResourceRepository resourceRepository;
    @Override
    public boolean sendEmail(int userId, String body, String subject) {
        boolean send = false;
        try{
            String email = userRepository.getEmailByUserId(userId);
//            System.out.println(email);

            if(email != null){
                SimpleMailMessage message = new SimpleMailMessage();

                message.setFrom("manulamadubhashana123@gmail.com");
                message.setTo(email);
                message.setText(body);
                message.setSubject(subject);

                javaMailSender.send(message);
//                System.out.println(body);
//                System.out.println(subject);

                send = true;
            }
            return send;
        }catch (Exception e){
            System.out.println(e.toString());
            return send;
        }
    }

    @Override
    public boolean sendAdminMail(int resourceId, String body, String subject) {
        boolean adminSend = false;
        try{
            String email = resourceRepository.getAminEmailByResourceId(resourceId);
//            System.out.println(email);

            if(email != null){
                SimpleMailMessage message = new SimpleMailMessage();

                message.setFrom("manulamadubhashana123@gmail.com");
                message.setTo(email);
                message.setText(body);
                message.setSubject(subject);

                javaMailSender.send(message);
//                System.out.println(body);
//                System.out.println(subject);

                adminSend = true;
            }
            return adminSend;
        }catch (Exception e){
            System.out.println(e.toString());
            return adminSend;
        }
    }
}
