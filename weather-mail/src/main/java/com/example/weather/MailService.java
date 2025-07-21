package com.example.weather;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailService {

    public static void main(String[] args) {
        final String username = "weathermailjob@gmail.com";
        final String password = "bbhgyjmshlurvkpl";
        String unername2 = "kaffa2018@gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(unername2));
            message.setSubject("テストメール");
            message.setText("これは Maven で送ったテストメールです。");

            Transport.send(message);
            System.out.println("メール送信成功！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}