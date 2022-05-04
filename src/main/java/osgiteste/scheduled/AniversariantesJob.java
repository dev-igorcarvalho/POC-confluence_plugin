package osgiteste.scheduled;


import com.atlassian.scheduler.JobRunner;
import com.atlassian.scheduler.JobRunnerRequest;
import com.atlassian.scheduler.JobRunnerResponse;
import org.springframework.stereotype.Component;
import osgiteste.interactor.SendAniversariantesAsync;
import osgiteste.util.Logger;

@Component
public class AniversariantesJob implements JobRunner {

    private final SendAniversariantesAsync sendAniversariantesAsync;

    public AniversariantesJob(SendAniversariantesAsync sendAniversariantesAsync) {
        this.sendAniversariantesAsync = sendAniversariantesAsync;
    }

    @Override
    public JobRunnerResponse runJob(JobRunnerRequest request) {
        sendAniversariantesAsync.execute();
        Logger.info("JOB FINALIZADO, A TASK ASINCRONA CONTINUARA EM PARALELO");
        return JobRunnerResponse.success("JOB FINALIZADO COM SUCESSO");
    }
}

