package osgiteste.interactor;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.client.ANIVERSARIANTE;
import osgiteste.util.PropertiesInteractor;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Component
public class SendAniversariantesDiaMail {
    private final JavaMailSender javaMailSender;
    private final GenerateHtmlMailFromVelocityTemplate generateHtmlMailFromVelocityTemplate;

    private final PropertiesInteractor propertiesInteractor;

    public SendAniversariantesDiaMail(JavaMailSender javaMailSender, GenerateHtmlMailFromVelocityTemplate generateHtmlMailFromVelocityTemplate, PropertiesInteractor propertiesInteractor) {
        this.javaMailSender = javaMailSender;
        this.generateHtmlMailFromVelocityTemplate = generateHtmlMailFromVelocityTemplate;
        this.propertiesInteractor = propertiesInteractor;
    }

    public void execute(List<ANIVERSARIANTE> aniversariantes) {
        if (aniversariantes.isEmpty()) {
            return;
        }
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        try {
            helper.setTo(propertiesInteractor.getStringByKey("aniversariantes.mail.destinatario"));
            helper.setSubject(propertiesInteractor.getStringByKey("aniversariantes.mail.assunto"));
            helper.setFrom(propertiesInteractor.getStringByKey("aniversariantes.mail.remetente"));
            helper.setText(generateHtmlMailFromVelocityTemplate.execute(aniversariantes), true);
            javaMailSender.send(mail);
        } catch (MailException | MessagingException e) {
            osgiteste.util.Logger.error("Houve algum problema no envio de email", e);
            throw new RuntimeException(); //TODO TROCAR POR PERSONALZIADA
        }
    }
}
