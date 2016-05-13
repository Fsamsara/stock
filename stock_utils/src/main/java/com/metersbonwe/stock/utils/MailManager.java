package com.metersbonwe.stock.utils;

import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailManager {

    public static final Log log = LogFactory.getLog(MailManager.class);

    private static JavaMailSenderImpl mailSender;

    private static String from;

    public static void sendMail(String subject, String to, String text)
            throws Exception {
        MimeMessage me = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(me, true, "GBK");
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text, true);
        mailSender.send(me);
    }

    public static void sendMail(String subject, String[] tos, String text)
            throws Exception {
        MimeMessage me = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(me, true, "GBK");
        message.setFrom(from);
        message.setTo(tos[0]);
        message.setCc(tos); // 抄送
        message.setSubject(subject);
        message.setText(text, true);
        mailSender.send(me);
    }

    public JavaMailSenderImpl getMailSender() {
        return mailSender;
    }

    public String getFrom() {
        return from;
    }

    public static void setMailSender(JavaMailSenderImpl mailSender) {
        MailManager.mailSender = mailSender;
    }

    public static void setFrom(String from) {
        MailManager.from = from;
    }

}
