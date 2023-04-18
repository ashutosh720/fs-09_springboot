package org.geekster.email;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailTemplate {
    public static void main(String[] args) {

       String fromAdd="ashutoshrana1999@gmail.com";
       String toAdd="jbsrana@gmail.com";
       String ccAdd="jahnaviwrites21@gmail.com";
       String body="Not send through Gmail!";

       try{
           sendMailWithoutAttachment(fromAdd,toAdd,ccAdd,body);
       } catch (MessagingException e) {
           e.printStackTrace();
       }
    }

    public static void sendMailWithoutAttachment(String fromAddress,String toAddress,String ccAddress,String messageBody) throws MessagingException {
        Properties properties = System.getProperties();
        // properties needed for establishing connection with email service provider--gmail
        // 1.host name
        // 2.port number
        // 3.ssl leve
        // 4.authentication parameter

        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        // 1. Creating session for establishing connection with Gmail server

        Session session = Session.getInstance(properties,new Authenticator(){

            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("ashutoshrana1999@gmail.com","nijhevtrwwklqdla");
            }


        });

        // 2. Compose the mail
        //addFrom & setFrom

        MimeMessage message = new MimeMessage(session);
        message.setFrom(fromAddress);
        message.addRecipients(Message.RecipientType.TO,toAddress);
        message.addRecipients(Message.RecipientType.CC,ccAddress);
        message.setSubject("This is sent from IntelliJ");
        message.setText(messageBody);

        // 3. send the mail

        Transport.send(message);
        System.out.println("Email Sent Successfully...");

    }
}