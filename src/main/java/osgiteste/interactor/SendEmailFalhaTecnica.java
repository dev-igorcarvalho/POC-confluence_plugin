package osgiteste.interactor;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class SendEmailFalhaTecnica {
    private final JavaMailSender javaMailSender;

    public SendEmailFalhaTecnica(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void execute() {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        try {
            helper.setTo("igor.carvalho@terceiro.rnp.br");
            helper.setSubject("Não é virús, não é bug, é so o Igor testando uns emails ❤️");
            helper.setFrom("Confluence");
            helper.setText("O envio falhou", true);
            javaMailSender.send(mail);
        } catch (MailException | MessagingException e) {
            osgiteste.util.Logger.error("Houve algum problema no envio de email", e);
        }
    }
}
