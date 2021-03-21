package org.zx.springboot0319.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceTest {
    @Autowired
    MailService mailService;
    String from = "1793024847@qq.com";
    String to = "1793024847@qq.com";
    String cc = "zxingwork@163.com";
    String subject = "javamailTest";
    String content = "javamailContent";
    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail(
                "1793024847@qq.com",
                "1793024847@qq.com",
                "zxingwork@163.com",
                "测试邮件主题",
                "测试邮件内容");
    }

    @Test
    void sendAttachFileMail() {
        mailService.sendAttachFileMail(
                "1793024847@qq.com",
                "1793024847@qq.com",
                "zxingwork@163.com",
                "ass",
                "ass",
                new File("/Users/zhangxing/Downloads/ass-women-model-pornstar-blonde-1176230.jpg")
        );
    }

    @Test
    void sendMailWithImg() {
        mailService.sendMailWithImg(from, to, cc, subject,
                "<div><img src='cid:p1' /><img src='cid:p2' /></div>", new String[]{"/Users/zhangxing/Downloads/ass-women-model-pornstar-blonde-1176230.jpg", "/Users/zhangxing/Downloads/2.jpg"}, new String[]{"p1", "p2"});
    }
}