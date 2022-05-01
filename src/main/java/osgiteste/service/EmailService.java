package osgiteste.service;


import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import osgiteste.api.soap.client.service.AniversariantesServiceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * Created by : 01001001 01000011 at 29/06/2021
 */
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
//    private final VelocityEngine velocityEngine;
    private final AniversariantesServiceImpl aniversariantesService;

    public EmailService(JavaMailSender javaMailSender, AniversariantesServiceImpl aniversariantesService) {
        this.javaMailSender = javaMailSender;
//        this.velocityEngine = velocityEngine;
        this.aniversariantesService = aniversariantesService;
    }


    public void enviarEmailAniversariantes() {
        // TODO: mudar para html mail
        // TODO: criar arquivos pros templates

        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        try {
            helper.setTo("igor.carvalho@datagrupo.com.br");
            helper.setSubject("Não é virús, não é bug, é so o Igor testando uns emails ❤️");
            helper.setFrom("Confluence");
            helper.setText(gerarMsgContato(), true);
            javaMailSender.send(mail);
        } catch (MailException | MessagingException e) {
            System.out.println("Houve algum problema no envio de email" + e);
//            log.error("Houve algum problema no envio de email", e);
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

