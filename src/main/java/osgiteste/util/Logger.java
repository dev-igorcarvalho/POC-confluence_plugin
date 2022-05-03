package osgiteste.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

//O logger 4 j nao estava funcionando dentro do atlassian sdk
public class Logger {
    public static void error(String var1, Throwable var2) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        String format = String.format("%s :: %s %s", now, var1, var2.getMessage());
        System.out.println(format);
        var2.printStackTrace();
    }

    public static void info(String var1) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        String format = String.format("%s :: %s", now, var1);
        System.out.println(format);
    }
}
