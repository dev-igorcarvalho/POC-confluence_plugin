package osgiteste.interactor;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import osgiteste.util.PropertiesInteractor;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class SendEmailFalhaTecnica {
    private final JavaMailSender javaMailSender;

    private final GenerateFalhaTecnicaHtmlMailFromVelocityTemplate generateFalhaTecnicaHtmlMailFromVelocityTemplate;
    private final PropertiesInteractor propertiesInteractor;

    public SendEmailFalhaTecnica(JavaMailSender javaMailSender, GenerateFalhaTecnicaHtmlMailFromVelocityTemplate generateFalhaTecnicaHtmlMailFromVelocityTemplate, PropertiesInteractor propertiesInteractor) {
        this.javaMailSender = javaMailSender;
        this.generateFalhaTecnicaHtmlMailFromVelocityTemplate = generateFalhaTecnicaHtmlMailFromVelocityTemplate;
        this.propertiesInteractor = propertiesInteractor;
    }

    public void execute(String errorMsg) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        try {
            helper.setTo(propertiesInteractor.getStringByKey("mail.falha.destinatario"));
            helper.setSubject(propertiesInteractor.getStringByKey("mail.falha.assunto"));
            helper.setFrom(propertiesInteractor.getStringByKey("mail.falha.remetente"));
            helper.setText(generateFalhaTecnicaHtmlMailFromVelocityTemplate.execute(errorMsg), true);
            javaMailSender.send(mail);
        } catch (MailException | MessagingException e) {
            osgiteste.util.Logger.error("Houve algum problema no envio de email de falha tecnica", e);
        }
    }
}
