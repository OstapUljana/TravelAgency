package com.vz.jpa.facade;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.mail.*;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
 
//@Path("/mail")
public class MailSending {
 
    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;
 //@POST()
    
    public void sendPassword(String emailAdress, String restoringPassword) {
        String mailBody = "Test email Travel Agwncy Password restore. "+" Your new password is:  "+restoringPassword + "<br><br> Regards, <br>Travel Agency Admin";
        try {
            generateAndSendEmail(emailAdress, mailBody);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
 
 
    private static void generateAndSendEmail(String emailAdress, String mBody) throws MessagingException {
    String mailBody = mBody;
//Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587"); // TLS Port
        mailServerProperties.put("mail.smtp.auth", "true"); // Enable Authentication
        mailServerProperties.put("mail.smtp.starttls.enable", "true"); // Enable StartTLS
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("Mail Server Properties have been setup successfully..");
 
//Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        //generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("ostapulja@gmail.com"));       //кому
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(emailAdress));
        generateMailMessage.setSubject("Travel Agency J-7");
        String emailBody = mailBody;
        try {
            generateMailMessage.setFrom(new InternetAddress("aleksandrkitaygora@gmail.com", "TravelAgency.com(localhost:8080)  - Admin"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");
 
//Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");
        // Enter your correct gmail UserID and Password
        transport.connect("smtp.gmail.com", "aleksandrkitaygora@gmail.com", "loveoflife");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}
