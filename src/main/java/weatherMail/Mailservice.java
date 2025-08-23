package weatherMail;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
public class Mailservice {
	 public void sendMail(String subject, String body) {
	        final String username = "weathermailjob@gmail.com";  
	        final String password = "bbhgyjmshlurvkpl";  

	        String host = "smtp.gmail.com";
	        int port = 587;

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", String.valueOf(port));

	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });

	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("weathermailjob@gmail.com\n"
	            		+ ""));
	            message.setSubject(subject);
	            message.setText(body);

	            Transport.send(message);
	            System.out.println("メール送信成功！");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }

	    // 簡単なテスト用 main メソッド
	    public static void main(String[] args) {
	        Mailservice mailService = new Mailservice();
	        mailService.sendMail("テストメール", "これはJavaから送信したテストメールです。");
	    }
	
}
