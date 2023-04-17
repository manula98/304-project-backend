package com.CS304Project.Project.Service;

public interface EmailService {
    boolean sendEmail(int userId, String body, String subject);
    boolean sendAdminMail(int resourceId, String body, String subject);
}
