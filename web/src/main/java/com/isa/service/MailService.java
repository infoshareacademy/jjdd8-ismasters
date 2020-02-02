package com.isa.service;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;

@RequestScoped
public class MailService {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public void createMail(Email from, String subject, Email to, Content content) throws IOException {
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        logger.info("Response status: {}", response.getStatusCode());
        logger.info("Response body:  {}", response.getBody());
        logger.info("Response header: {}", response.getHeaders());
    }
    public void addedToNewsletter(String userEmail) throws IOException {
        Email from = new Email("ismasters.infoshare@gmail.com");
        String subject = "Newsletter.";
        Email to = new Email(userEmail);
        Content content = new Content("text/plain", "Zapisano do Newslettera. Od dziś będziesz na bieżacą ze wszystkimi imprezami w Trójmieście. Zapraszamy!");
        createMail(from, subject, to, content);
    }
    private void createMail2(Email from, String subject, Email to, Content content) throws IOException {
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }
    public void sendApprove(String emailRecipient) throws IOException {
        Email from = new Email("ismasters.infoshare@gmail.com");
        String subject = "Vacation Manager notification. Your request has been approved.";
        Email to = new Email(emailRecipient);
        Content content = new Content("text/plain", "Please be informed your vacation request has been approved.");
        createMail2(from, subject, to, content);
    }
}