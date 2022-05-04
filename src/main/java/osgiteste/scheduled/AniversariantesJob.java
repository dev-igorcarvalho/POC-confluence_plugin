package osgiteste.scheduled;


import com.atlassian.scheduler.JobRunner;
import com.atlassian.scheduler.JobRunnerRequest;
import com.atlassian.scheduler.JobRunnerResponse;
import dev.failsafe.*;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.client.ANIVERSARIANTE;
import osgiteste.api.soap.client.service.AniversariantesServiceImpl;
import osgiteste.interactor.FecthAniversariantesDiaFromProtheus;
import osgiteste.interactor.GenerateAniversariantesDia;
import osgiteste.interactor.SendAniversariantesDiaMail;
import osgiteste.interactor.SendEmailFalhaTecnica;
import osgiteste.service.EmailService;
import osgiteste.util.Logger;
import osgiteste.util.PropertiesInteractor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
public class AniversariantesJob implements JobRunner {

    private final PropertiesInteractor propertiesInteractor;
    private final EmailService emailService;
    private final AniversariantesServiceImpl aniversariantesService;
    private final SendEmailFalhaTecnica sendEmailFalhaTecnica;

    private final FecthAniversariantesDiaFromProtheus fecthAniversariantesDiaFromProtheus;
    private final GenerateAniversariantesDia generateAniversariantesDia;
    private final SendAniversariantesDiaMail sendAniversariantesDiaMail;

    public AniversariantesJob(
          PropertiesInteractor propertiesInteractor, EmailService emailService,
          AniversariantesServiceImpl aniversariantesService, SendEmailFalhaTecnica sendEmailFalhaTecnica, FecthAniversariantesDiaFromProtheus fecthAniversariantesDiaFromProtheus, GenerateAniversariantesDia generateAniversariantesDia, SendAniversariantesDiaMail sendAniversariantesDiaMail) {
        this.propertiesInteractor = propertiesInteractor;
        this.emailService = emailService;
        this.aniversariantesService = aniversariantesService;
        this.sendEmailFalhaTecnica = sendEmailFalhaTecnica;
        this.fecthAniversariantesDiaFromProtheus = fecthAniversariantesDiaFromProtheus;
        this.generateAniversariantesDia = generateAniversariantesDia;
        this.sendAniversariantesDiaMail = sendAniversariantesDiaMail;
    }

    //todo adicionar um retry em caso de falha
    @Override
    public JobRunnerResponse runJob(JobRunnerRequest request) {
        sendAniversariantesAsync();
        Logger.info("JOB FINALIZADO, A TASK ASINCRONA CONTINUARA EM PARALELO");
        return JobRunnerResponse.success("JOB FINALIZADO COM SUCESSO");
    }

    private void sendAniversariantesAsync() {
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
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder()
              .handle(Throwable.class)
              .withDelay(Duration.ofSeconds(secondsToRetry))//todo passar para o properties
              .withMaxRetries(maxRetries)//todo passar para o properties
              .build();
        Fallback<Object> fallback = Fallback.of(() -> enviarNotificacaoDeFalha());
        Timeout<Object> timeout = Timeout.of(Duration.ofSeconds(secondsToTimeout)); //todo passar para o properties
        FailsafeExecutor<Object> failsafeExecutor = Failsafe.with(fallback)
              .compose(retryPolicy)
              .compose(timeout);
        return failsafeExecutor;
    }

    private void enviarEmailAniversariantes() {
//        List<ANIVERSARIANTE> aniversariantes = getAniversariantesFromProtheus();
        ANIVERSARIANTE[] protheusResult = fecthAniversariantesDiaFromProtheus.execute();
        List<ANIVERSARIANTE> aniversariantes = generateAniversariantesDia.execute(protheusResult);
        printAniverasriantes(aniversariantes);
//        emailService.enviarEmailAniversariantes(aniversariantes);
        sendAniversariantesDiaMail.execute(aniversariantes);
    }

    private void enviarNotificacaoDeFalha() {
        Logger.info("TODAS TENTATIVAS FALHARAM");
//        emailService.enviarEmailFalha();
        sendEmailFalhaTecnica.execute();
    }

//    private List<ANIVERSARIANTE> getAniversariantesFromProtheus() {
//        Date dataInicio = Date.from(LocalDate.of(2022, Month.MAY, 2).atStartOfDay(ZoneId.systemDefault()).toInstant());
//        Date dataFim = Date.from(LocalDate.of(2022, Month.MAY, 2).atStartOfDay(ZoneId.systemDefault()).toInstant());
////        Map<String, Object> result = aniversariantesService.getAniversariantesDoDia();
//        Map<String, Object> result = aniversariantesService.getAniversariantesPorPeriodo(dataInicio, dataFim);
//
//        List<ANIVERSARIANTE> aniversariantes = (List<ANIVERSARIANTE>) result.get("aniversariantes");
//        //TODO empty nao eh erro, eh so nao enviar o email de aniversariantes
//        if (aniversariantes == null || aniversariantes.isEmpty()) throw new RuntimeException();
//        return aniversariantes;
//    }

    private void printAniverasriantes(List<ANIVERSARIANTE> aniversariantes) {
        System.out.println("");
        System.out.println("************ ************ ANIVERSARIANTES DO DIA ************ ************");
        System.out.println("");
        System.out.println("");
        for (ANIVERSARIANTE el : aniversariantes) {
            System.out.println("NOME COMPLETO: " + el.getFUNCIONARIO_NOME_COMPLETO());
            System.out.println("FILIAL: " + el.getFUNCIONARIO_FILIAL());
            System.out.println("EMAIL: " + el.getFUNCIONARIO_EMAIL());
            System.out.println("AREA: " + el.getFUNCIONARIO_AREA());
            System.out.println("NUCLEO: " + el.getFUNCIONARIO_NUCLEO());
            System.out.println("FOTO: " + el.getFUNCIONARIO_FOTO());
            System.out.println("");
            System.out.println("");
        }
    }

}

