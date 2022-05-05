package osgiteste.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import org.springframework.stereotype.Component;
import osgiteste.interactor.GenerateAniversariantesHtmlMacroFromVelocityTemplate;

import java.util.Map;


@Component
public class AniversariantesMacro implements Macro {
    private final GenerateAniversariantesHtmlMacroFromVelocityTemplate generateHtmlPageFromVelocityTemplate;

    public AniversariantesMacro(GenerateAniversariantesHtmlMacroFromVelocityTemplate generateHtmlPageFromVelocityTemplate) {
        this.generateHtmlPageFromVelocityTemplate = generateHtmlPageFromVelocityTemplate;
    }

    @Override
    public String execute(Map<String, String> arg0, String arg1, ConversionContext arg2)
          throws MacroExecutionException {

//        Date dataAtual = new Date();
//        Locale BRAZIL = new Locale("pt", "BR");
//        SimpleDateFormat formatador = new SimpleDateFormat("dd MMMM", BRAZIL);
//        String dataFormatada = formatador.format(dataAtual);
//
//        AniversariantesService service = new AniversariantesServiceImpl();
//
//        Map<String, Object> result = service.getAniversariantesDoDia();
//
//        Map<String, Object> context = MacroUtils.defaultVelocityContext();
//        Object aniversariantes = result.get("aniversariantes");
//        context.put("aniversariantes", result.get("aniversariantes"));
//        context.put("msg", result.get("msg"));
//        context.put("dataAtual", dataFormatada.toUpperCase());
//        // Render the Template
//        return VelocityUtils.getRenderedTemplate("/templates/aniversariantes.vm", context);
        return generateHtmlPageFromVelocityTemplate.execute();

    }


    @Override
    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }


}
