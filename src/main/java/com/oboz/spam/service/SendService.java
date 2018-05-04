package com.oboz.spam.service;

import com.oboz.spam.crypt.Crypt;
import com.oboz.spam.entrypoint.SpamProperties;

import com.oboz.spam.model.SpamVariables;
import com.oboz.spam.repository.VariablesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
@Slf4j
public class SendService {
    @Autowired
    private SpamProperties spamProperties;

    @Autowired
    private VariablesRepository variablesRepository;

    private Session getSmtpSession() throws Exception {
        String password = new Crypt().hashDecode(spamProperties.getPassword());
        Session session = Session.getInstance(getSmtpProperies(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(spamProperties.getEmail(), password);
            }
        });
        return session;
    }

    private Properties getSmtpProperies() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", spamProperties.getSmtp().getAuth());
        properties.put("mail.smtp.starttls.enable", spamProperties.getSmtp().getStarttlsEnable());
        properties.put("mail.smtp.host", spamProperties.getSmtp().getHost());
        properties.put("mail.smtp.port", spamProperties.getSmtp().getPort());
        return properties;
    }

    public void sendTo(String Num) throws Exception {
        Session session = getSmtpSession();
        List<SpamVariables> spam = variablesRepository.findByNum(Num);
        Num = spam.get(0).getNum();
        String Price = spam.get(0).getPrice();
        String Carrier = spam.get(0).getCarrier();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your@mail.ru"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("rec@mail.ru"));
            message.setSubject("чото " + Num + " блаблабла");
            message.setText("чот по такой цене" + Price + "чойта" + Carrier);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
