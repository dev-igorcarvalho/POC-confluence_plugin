package osgiteste.interactor;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.client.ANIVERSARIANTE;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Component
public class SendAniversariantesDiaMail {
    private final JavaMailSender javaMailSender;
    private final GenerateHtmlMailFromVelocityTemplate generateHtmlMailFromVelocityTemplate;

    public SendAniversariantesDiaMail(JavaMailSender javaMailSender, GenerateHtmlMailFromVelocityTemplate generateHtmlMailFromVelocityTemplate) {
        this.javaMailSender = javaMailSender;
        this.generateHtmlMailFromVelocityTemplate = generateHtmlMailFromVelocityTemplate;
    }

    public void execute(List<ANIVERSARIANTE> aniversariantes) {
        if (aniversariantes.isEmpty()) {
            return;
        }
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        try {
            helper.setTo("igor.carvalho@terceiro.rnp.br");//TODO PEGAR DO PROPERTIES
            helper.setSubject("Não é virús, não é bug, é so o Igor testando uns emails ❤️");//TODO PEGAR DO PROPERTIES
            helper.setFrom("Confluence");//TODO PEGAR DO PROPERTIES
            helper.setText(generateHtmlMailFromVelocityTemplate.execute(aniversariantes), true);
            javaMailSender.send(mail);
        } catch (MailException | MessagingException e) {
            osgiteste.util.Logger.error("Houve algum problema no envio de email", e);
            throw new RuntimeException(); //TODO TROCAR POR PERSONALZIADA
        }
    }
}
