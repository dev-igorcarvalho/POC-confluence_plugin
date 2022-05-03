package osgiteste.scheduled;


import com.atlassian.scheduler.JobRunner;
import com.atlassian.scheduler.JobRunnerRequest;
import com.atlassian.scheduler.JobRunnerResponse;
import dev.failsafe.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.client.ANIVERSARIANTE;
import osgiteste.api.soap.client.service.AniversariantesServiceImpl;
import osgiteste.service.EmailService;
import osgiteste.util.Logger;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
public class AniversariantesJob implements JobRunner {

    private Environment env;
    private final EmailService emailService;

    private final AniversariantesServiceImpl aniversariantesService;

    public AniversariantesJob(
          Environment env, EmailService emailService,
          AniversariantesServiceImpl aniversariantesService) {
        this.env = env;
        this.emailService = emailService;
        this.aniversariantesService = aniversariantesService;
    }

    //todo adicionar um retry em caso de falha
    @Override
    public JobRunnerResponse runJob(JobRunnerRequest request) {
        sendAniversariantesAsync();
        Logger.info("JOB FINALIZADO, A TASK ASINCRONA CONTINUARA EM PARALELO");
        return JobRunnerResponse.success("JOB FINALIZADO COM SUCESSO");

//
//
//        if (request.isCancellationRequested()) {
//            return JobRunnerResponse.aborted("JOB NEW ANIVERSARIANTES ABORTADO");
//        }
//
//        try {

//            if (aniversariantes != null && !aniversariantes.isEmpty()) {
//                printAniverasriantes(aniversariantes);
//                emailService.enviarEmailAniversariantes();
//            } else {
////                TODO:email de error report pros adm
//            }
//
//            return JobRunnerResponse.success();
//        } catch (Exception e) {
//            System.out.println("ERRO NA EXECUÇÃO DO JOB JOB NEW ANIVERSARIANTES - " + e.getMessage());
//            return JobRunnerResponse.failed(e.getMessage());
//        }
    }

    private void sendAniversariantesAsync() {
        FailsafeExecutor<Object> failsafeExecutor = getObjectFailsafeExecutor();
        CompletableFuture<Void> future = failsafeExecutor.runAsync((e) -> {
            Logger.info("EXECUTANDO ENVIO DE ANIVERSARIANTES, TENTATIVA -> " + e.getAttemptCount());
            enviarEmailAniversariantes();
        });
    }

    private FailsafeExecutor<Object> getObjectFailsafeExecutor() {
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder()
              .handle(Throwable.class)
              .withDelay(Duration.ofSeconds(1))//todo passar para o properties
              .withMaxRetries(2)//todo passar para o properties
              .build();
        Fallback<Object> fallback = Fallback.of(() -> enviarNotificacaoDeFalha());
        Timeout<Object> timeout = Timeout.of(Duration.ofSeconds(10)); //todo passar para o properties
        FailsafeExecutor<Object> failsafeExecutor = Failsafe.with(fallback)
              .compose(retryPolicy)
              .compose(timeout);
        return failsafeExecutor;
    }

    private void enviarEmailAniversariantes() {
        List<ANIVERSARIANTE> aniversariantes = getAniversariantesFromProtheus();
        printAniverasriantes(aniversariantes);
        emailService.enviarEmailAniversariantes();
    }

    private void enviarNotificacaoDeFalha() {
        Logger.info("TODAS TENTATIVAS FALHARAM");
    }

    private List<ANIVERSARIANTE> getAniversariantesFromProtheus() {
        Map<String, Object> result = aniversariantesService.getAniversariantesDoDia();
        List<ANIVERSARIANTE> aniversariantes = (List<ANIVERSARIANTE>) result.get("aniversariantes");
        if (aniversariantes == null || aniversariantes.isEmpty()) throw new RuntimeException();
        return aniversariantes;
    }

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

