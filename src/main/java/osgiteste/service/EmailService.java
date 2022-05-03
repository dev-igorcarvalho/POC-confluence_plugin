package osgiteste.service;


import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import osgiteste.api.soap.client.service.AniversariantesServiceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by : 01001001 01000011 at 29/06/2021
 */
@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender javaMailSender;
    private final AniversariantesServiceImpl aniversariantesService;

    public EmailService(JavaMailSender javaMailSender, AniversariantesServiceImpl aniversariantesService) {
        this.javaMailSender = javaMailSender;
        this.aniversariantesService = aniversariantesService;
    }


    public void enviarEmailAniversariantes() {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        try {
            helper.setTo("igor.carvalho@terceiro.rnp.br");
            helper.setSubject("Não é virús, não é bug, é so o Igor testando uns emails ❤️");
            helper.setFrom("Confluence");
            helper.setText(geralHtmlMailDoTempalte(), true);
            javaMailSender.send(mail);
        } catch (MailException | MessagingException e) {
            osgiteste.util.Logger.error("Houve algum problema no envio de email", e);
        }
    }

    public void enviarEmailFalha() {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        try {
            helper.setTo("igor.carvalho@terceiro.rnp.br");
            helper.setSubject("Não é virús, não é bug, é so o Igor testando uns emails ❤️");
            helper.setFrom("Confluence");
            helper.setText("O envio falho", true);
            javaMailSender.send(mail);
        } catch (MailException | MessagingException e) {
            osgiteste.util.Logger.error("Houve algum problema no envio de email", e);
        }
    }

    private String gerarMsgContato() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h4> Solicitação de ajuda/recusa de contrato</h4>")
              .append("<p><strong>")
              .append("contato.getUsuario().getNome()")
              .append("</strong></p>")
              .append("<p><strong>")
              .append("contato.getUsuario().getEmail()")
              .append("</strong></p>")
              .append("<p><strong>")
              .append("contato.getUsuario().getTelefone()")
              .append("</strong></p>")
              .append("<h4>Mensagem</h4>")
              .append("<p>")
              .append("contato.getMensagem()")
              .append("</p>");
        return sb.toString();
    }

    private String geralHtmlMailDoTempalte() {
        Map<String, Object> result = aniversariantesService.getAniversariantesDoDia();
        Date dataAtual = new Date();
        Locale BRAZIL = new Locale("pt", "BR");
        SimpleDateFormat formatador = new SimpleDateFormat("dd MMMM", BRAZIL);
        String dataFormatada = formatador.format(dataAtual);

        Map<String, Object> context = MacroUtils.defaultVelocityContext();
        context.put("aniversariantes", result.get("aniversariantes"));
        context.put("msg", result.get("msg"));
        context.put("dataAtual", dataFormatada.toUpperCase());
        // Render the Template
        return VelocityUtils.getRenderedTemplate("/templates/mail.vm", context);
    }
//    private String gerarHtmlMailDoTemplate(Map<String, Object> model) {
//        Map<String, Object> result = aniversariantesService.getAniversariantesDoDia();
//
//        Map<String, Object> context = MacroUtils.defaultVelocityContext();
//        context.put("aniversariantes", result.get("aniversariantes"));
//        context.put("msg", result.get("msg"));
//        model=context;
//        StringBuffer content = new StringBuffer();
//        try {
//            content.append(VelocityEngineUtils.
//                  .mergeTemplateIntoString(
//                        velocityEngine,
//                        "/templates/email.vm",
//                        "UTF-8",
//                        model));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return content.toString();
//    }
}

