package osgiteste.interactor;

import dev.failsafe.*;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.generated.ANIVERSARIANTE;
import osgiteste.util.Logger;
import osgiteste.util.PropertiesInteractor;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class SendAniversariantesAsync {
    private final PropertiesInteractor propertiesInteractor;
    private final SendEmailFalhaTecnica sendEmailFalhaTecnica;
    private final FecthAniversariantesDiaFromProtheus fecthAniversariantesDiaFromProtheus;
    private final GenerateAniversariantesDia generateAniversariantesDia;
    private final SendAniversariantesDiaMail sendAniversariantesDiaMail;
    private final ConsolePrintAniversaraintes consolePrintAniversaraintes;

    public SendAniversariantesAsync(PropertiesInteractor propertiesInteractor, SendEmailFalhaTecnica sendEmailFalhaTecnica, FecthAniversariantesDiaFromProtheus fecthAniversariantesDiaFromProtheus, GenerateAniversariantesDia generateAniversariantesDia, SendAniversariantesDiaMail sendAniversariantesDiaMail, ConsolePrintAniversaraintes consolePrintAniversaraintes) {
        this.propertiesInteractor = propertiesInteractor;
        this.sendEmailFalhaTecnica = sendEmailFalhaTecnica;
        this.fecthAniversariantesDiaFromProtheus = fecthAniversariantesDiaFromProtheus;
        this.generateAniversariantesDia = generateAniversariantesDia;
        this.sendAniversariantesDiaMail = sendAniversariantesDiaMail;
        this.consolePrintAniversaraintes = consolePrintAniversaraintes;
    }


    public void execute() {
        FailsafeExecutor<Object> failsafeExecutor = getObjectFailsafeExecutor();
        CompletableFuture<Void> future = failsafeExecutor.runAsync((e) -> {
            Logger.info("EXECUTANDO ENVIO DE ANIVERSARIANTES, TENTATIVA -> " + e.getAttemptCount());
            enviarEmailAniversariantes();
        });
    }

    private FailsafeExecutor<Object> getObjectFailsafeExecutor() {
        int secondsToTimeout = propertiesInteractor.getIntByKey("aniversariantes.job.timeout", 10);
        int maxRetries = propertiesInteractor.getIntByKey("aniversariantes.job.maxRetries", 2);
        int secondsToRetry = propertiesInteractor.getIntByKey("aniversariantes.job.retryDelay", 1);
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder().handle(Throwable.class).withDelay(Duration.ofSeconds(secondsToRetry))
              .withMaxRetries(maxRetries)
              .build();
        Fallback<Object> fallback = Fallback.ofException(e -> {
            enviarNotificacaoDeFalha(e.getLastException().getMessage());
            return new RuntimeException(e.getLastException());
        });
        Timeout<Object> timeout = Timeout.of(Duration.ofSeconds(secondsToTimeout));

        FailsafeExecutor<Object> failsafeExecutor = Failsafe.with(fallback)
              .compose(retryPolicy)
//              .compose(timeout) // o timeout mascara a exception personalidade
              .onComplete((e) -> Logger.info("A TASK ASINCRONA FOI FINALIZADA"));
        return failsafeExecutor;
    }

    private void enviarEmailAniversariantes() {
        ANIVERSARIANTE[] protheusResult = fecthAniversariantesDiaFromProtheus.execute();
        List<ANIVERSARIANTE> aniversariantes = generateAniversariantesDia.execute(protheusResult);
        consolePrintAniversaraintes.execute(aniversariantes);
        sendAniversariantesDiaMail.execute(aniversariantes);
    }

    private void enviarNotificacaoDeFalha(String errorMsg) {
        Logger.info("TODAS TENTATIVAS FALHARAM");
        sendEmailFalhaTecnica.execute(errorMsg);
    }
}
