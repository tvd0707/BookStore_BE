package vn.tvd.BookStore_BE.service.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void sendEmail(String from, String to, String subject, String text) {
        //MimeMailMessage => có đính kèm media
        //SimpleMailMessage => nội dung text thông thường
        //SimpleMailMessage mailMessage = new SimpleMailMessage();

        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "UTF-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
        }catch (MessagingException e){
            throw new RuntimeException(e);
        }

        javaMailSender.send(mailMessage);
    }
}
