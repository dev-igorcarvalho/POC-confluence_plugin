package osgiteste.scheduled;


import com.atlassian.scheduler.JobRunner;
import com.atlassian.scheduler.JobRunnerRequest;
import com.atlassian.scheduler.JobRunnerResponse;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.client.ANIVERSARIANTE;
import osgiteste.api.soap.client.service.AniversariantesServiceImpl;
import osgiteste.service.EmailService;

import java.util.List;
import java.util.Map;

@Component
public class AniversariantesJob implements JobRunner {

    private final EmailService emailService;

    private final AniversariantesServiceImpl aniversariantesService;

    public AniversariantesJob(EmailService emailService, AniversariantesServiceImpl aniversariantesService) {
        this.emailService = emailService;
        this.aniversariantesService = aniversariantesService;
    }

    @Override
    public JobRunnerResponse runJob(JobRunnerRequest request) {

        if (request.isCancellationRequested()) {
            return JobRunnerResponse.aborted("JOB NEW ANIVERSARIANTES ABORTADO");
        }

        try {
            Map<String, Object> result = aniversariantesService.getAniversariantesDoDia();
            List<ANIVERSARIANTE> aniversariantes = (List<ANIVERSARIANTE>) result.get("aniversariantes");
            printAniverasriantes(aniversariantes);
            emailService.enviarEmailAniversariantes();
            return JobRunnerResponse.success();
        } catch (Exception e) {
            System.out.println("ERRO NA EXECUÇÃO DO JOB JOB NEW ANIVERSARIANTES - " + e.getMessage());
            return JobRunnerResponse.failed(e.getMessage());
        }
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
            System.out.println("CODIGO FOTO: " + "media.rnp.br/images/aniversariantes/" + el.getFUNCIONARIO_FOTO());
            System.out.println("");
            System.out.println("");
        }

    }

}

