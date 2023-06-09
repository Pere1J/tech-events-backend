package com.techevents.service;



import com.techevents.security.auth.AuthFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin("*")
@Service

public class SendMailService {
    @Autowired
    private JavaMailSender mail;
    @Autowired
    private AuthFacade authFacade;



    public ResponseEntity<?> send_mail(){
        String userMail = authFacade.getAuthUser().getEmail();

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo (userMail);
        email.setFrom("sendmailsala3@gmail.com");
        email.setSubject("Confirmación de incripción");
        email.setText("Gracias por inscribirse a este evento");

        mail.send(email);


        return new ResponseEntity<>(true, HttpStatus.OK);


    };


}
