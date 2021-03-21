package org.zx.springboot0319.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;
    public void sendSimpleMail(String from, String to, String cc, String subject, String content) {
        SimpleMailMessage simMsg = new SimpleMailMessage();
        simMsg.setFrom(from);
        simMsg.setTo(to);
        simMsg.setCc(cc);
        simMsg.setSubject(subject);
        simMsg.setText(content);
        javaMailSender.send(simMsg);
    }
    public void sendAttachFileMail(String from, String to, String cc, String subject, String content, File file){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(content);
            helper.addAttachment(file.getName(), file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void sendMailWithImg(String from, String to, String cc, String subject, String content,String[] srcPath ,String[] resIds){
        if (resIds.length != srcPath.length) {
            System.out.println("发送失败！");
        }else {
            try {
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(from);
                helper.setTo(to);
                helper.setCc(cc);
                helper.setSubject(subject);
                helper.setText(content, true);
                for (int i = 0; i < srcPath.length; i++) {
                    FileSystemResource res = new FileSystemResource(new File(srcPath[i]));
                    helper.addInline(resIds[i], res);
                }
                javaMailSender.send(mimeMessage);

            } catch (MessagingException e) {
                e.printStackTrace();
                System.out.println("发送失败");
            }
        }

    }
}
