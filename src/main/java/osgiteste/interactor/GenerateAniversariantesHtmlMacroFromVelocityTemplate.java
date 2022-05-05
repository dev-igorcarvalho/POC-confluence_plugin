package osgiteste.interactor;

import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.generated.ANIVERSARIANTE;
import osgiteste.util.PropertiesInteractor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public class GenerateAniversariantesHtmlMacroFromVelocityTemplate {
    private final FecthAniversariantesDiaFromProtheus fecthAniversariantesDiaFromProtheus;
    private final PropertiesInteractor propertiesInteractor;
    private final GenerateAniversariantesDia generateAniversariantesDia;

    public GenerateAniversariantesHtmlMacroFromVelocityTemplate(FecthAniversariantesDiaFromProtheus fecthAniversariantesDiaFromProtheus,
                                                                PropertiesInteractor propertiesInteractor, GenerateAniversariantesDia generateAniversariantesDia) {
        this.fecthAniversariantesDiaFromProtheus = fecthAniversariantesDiaFromProtheus;
        this.propertiesInteractor = propertiesInteractor;
        this.generateAniversariantesDia = generateAniversariantesDia;
    }

    public String execute() {
        Date dataAtual = new Date();
        Locale BRAZIL = new Locale("pt", "BR");
        SimpleDateFormat formatador = new SimpleDateFormat("dd MMMM", BRAZIL);
        String dataFormatada = formatador.format(dataAtual);
        List<ANIVERSARIANTE> result = generateAniversariantesDia.execute(fecthAniversariantesDiaFromProtheus.execute());
        Map<String, Object> context = MacroUtils.defaultVelocityContext();
        if (result.size() == 0)
            context.put("msg", propertiesInteractor.getStringByKey("aniversariantes.msg.semAniversariantes"));
        context.put("aniversariantes", result);
        context.put("dataAtual", dataFormatada.toUpperCase());
        return VelocityUtils.getRenderedTemplate("/templates/aniversariantes.vm", context);
    }
}
