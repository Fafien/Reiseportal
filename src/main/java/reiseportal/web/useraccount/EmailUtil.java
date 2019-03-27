/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web.useraccount;

/**
 *
 * @author Fabian Hupe
 */

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

        static Properties props;
        final static String fromMail = "ihrreiseportal@gmail.com";
        final static String password = "AbC1234!";
        static Session session;
        static Authenticator auth;
    
	public static void sendEmail(String toEmail, String subject, String body){
            props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); 
            props.put("mail.smtp.socketFactory.port", "465"); 
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
                    
            auth = new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromMail, password);
                }
            };
                    
            session = Session.getDefaultInstance(props, auth);
            
            try{
                MimeMessage msg = new MimeMessage(session);
                //set message headers
                msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
                msg.addHeader("format", "flowed");
                msg.addHeader("Content-Transfer-Encoding", "8bit");

                msg.setFrom(new InternetAddress("ihrreiseportal@gmail.com"));

                msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

                msg.setSubject(subject, "UTF-8");

                msg.setContent(body, "text/html");

                msg.setSentDate(new Date());

                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
                Transport.send(msg);  
	    }
	    catch (Exception e) {
                e.printStackTrace();
	    }
	}
}

