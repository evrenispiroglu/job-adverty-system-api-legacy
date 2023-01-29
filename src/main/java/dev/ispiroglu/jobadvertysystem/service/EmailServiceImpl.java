package dev.ispiroglu.jobadvertysystem.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailServiceImpl {


  private final JavaMailSender emailSender;

  public EmailServiceImpl(JavaMailSender emailSender) {
    this.emailSender = emailSender;
  }


  public void sendSimpleMessage(
      String to, String subject, String text) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("noreply@lcwaikiki.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    log.info("Sending email to {}. Payload {}", to, text);
    emailSender.send(message);
  }
}