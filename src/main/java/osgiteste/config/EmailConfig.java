package osgiteste.config;


import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("noreply@datagrupo.com.br");
        mailSender.setPassword("m4st3rr00t");
//        mailSender.setUsername("helio.lima@guedder.com");
//        mailSender.setPassword("tcdjbutkymwssdnz");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
//    @Bean
//    public VelocityEngine velocityEngine() throws VelocityException, IOException{
//        VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();
//        Properties props = new Properties();
//        props.put("resource.loader", "class");
//        props.put("class.resource.loader.class",
//              "org.apache.velocity.runtime.resource.loader." +
//                    "ClasspathResourceLoader");
//        factory.setVelocityProperties(props);
//
//        return factory.createVelocityEngine();
//    }
}
